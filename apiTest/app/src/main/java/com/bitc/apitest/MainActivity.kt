package com.bitc.apitest

import android.os.AsyncTask
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.bitc.apitest.databinding.ActivityMainBinding
import okhttp3.Response
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.StringReader
import java.net.URL
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

data class WEATHER (val response : RESPONSE)
data class RESPONSE(val header : HEADER, val body : BODY)
data class HEADER(val resultCode : Int, val resultMsg : String)
data class BODY(val dataType : String, val items : ITEMS)
data class ITEMS(val item : List<ITEM>)
// category : 자료 구분 코드, fcstDate : 예측 날짜, fcstTime : 예측 시간, fcstValue : 예보 값
data class ITEM(val category : String, val fcstDate : String, val fcstTime : String, val fcstValue : String)

private val retrofit = Retrofit.Builder()
    .baseUrl("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object ApiObject {
    val retrofitService: WeatherInterface by lazy {
        retrofit.create(WeatherInterface::class.java)
    }
}

class MainActivity : AppCompatActivity() {

    lateinit var tvRainRatio : TextView     // 강수 확률
    lateinit var tvRainType : TextView      // 강수 형태
    lateinit var tvHumidity : TextView      // 습도
    lateinit var tvSky : TextView           // 하늘 상태
    lateinit var tvTemp : TextView          // 온도
    lateinit var btnRefresh : Button        // 새로고침 버튼

    var base_date = "20210510"  // 발표 일자
    var base_time = "1400"      // 발표 시각
    var nx = "0"               // 예보지점 X 좌표
    var ny = "0"              // 예보지점 Y 좌표

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tvRainRatio = binding.tvRainRatio
        tvRainType = binding.tvRainType
        tvHumidity = binding.tvHumidity
        tvSky = binding.tvSky
        tvTemp = binding.tvTemp
        btnRefresh = binding.btnRefresh

        setWeather(nx, ny)

        // <새로고침> 버튼 누를 때 날씨 정보 다시 가져오기
        btnRefresh.setOnClickListener {
            setWeather(nx, ny)
        }

    }

    fun setWeather(nx : String, ny : String) {
        // 준비 단계 : base_date(발표 일자), base_time(발표 시각)
        // 현재 날짜, 시간 정보 가져오기
        val cal = Calendar.getInstance()
        base_date = SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(cal.time) // 현재 날짜
        val time = SimpleDateFormat("HH", Locale.getDefault()).format(cal.time) // 현재 시간
        // API 가져오기 적당하게 변환
        base_time = getTime(time)
        // 동네예보  API는 3시간마다 현재시간+4시간 뒤의 날씨 예보를 알려주기 때문에
        // 현재 시각이 00시가 넘었다면 어제 예보한 데이터를 가져와야함
        if (base_time >= "2000") {
            cal.add(Calendar.DATE, -1).toString()
            base_date = SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(cal.time)
        }

        // 날씨 정보 가져오기
        // (응답 자료 형식-"JSON", 한 페이지 결과 수 = 10, 페이지 번호 = 1, 발표 날싸, 발표 시각, 예보지점 좌표)
        val call = ApiObject.retrofitService.GetWeather("JSON", 10, 1, base_date, base_time, nx, ny)
            .apply {

                // 비동기적으로 실행하기
                enqueue(object : retrofit2.Callback<WEATHER> {
                    // 응답 성공 시
                    override fun onResponse(
                        call: Call<WEATHER>,
                        response: retrofit2.Response<WEATHER>
                    ) {
                        if (response.isSuccessful) {
                            // 날씨 정보 가져오기
                            var it: List<ITEM> = response.body()!!.response.body.items.item

                            var rainRatio = ""      // 강수 확률
                            var rainType = ""       // 강수 형태
                            var humidity = ""       // 습도
                            var sky = ""            // 하능 상태
                            var temp = ""           // 기온
                            for (i in 0..9) {
                                when(it[i].category) {
                                    "POP" -> rainRatio = it[i].fcstValue    // 강수 기온
                                    "PTY" -> rainType = it[i].fcstValue     // 강수 형태
                                    "REH" -> humidity = it[i].fcstValue     // 습도
                                    "SKY" -> sky = it[i].fcstValue          // 하늘 상태
                                    "T3H" -> temp = it[i].fcstValue         // 기온
                                    else -> continue
                                }

                            }
                            // 날씨 정보 텍스트뷰에 보이게 하기
                            setWeather(rainRatio, rainType, humidity, sky, temp)

                            // 토스트 띄우기
                            Toast.makeText(applicationContext, it[0].fcstDate + ", " + it[0].fcstTime + "의 날씨 정보입니다.", Toast.LENGTH_SHORT).show()
                        }
                    }

                    // 응답 실패 시
                    override fun onFailure(call: Call<WEATHER>, t: Throwable) {
                        Log.d("api fail", t.message.toString())
                    }
                })
            }
    }

    fun setWeather(rainRatio : String, rainType : String, humidity : String, sky : String, temp : String) {
        // 강수 확률
        tvRainRatio.text = rainRatio + "%"
        // 강수 형태
        var result = ""
        when(rainType) {
            "0" -> result = "없음"
            "1" -> result = "비"
            "2" -> result = "비/눈"
            "3" -> result = "눈"
            "4" -> result = "소나기"
            "5" -> result = "빗방울"
            "6" -> result = "빗방울/눈날림"
            "7" -> result = "눈날림"
            else -> "오류"
        }
        tvRainType.text = result
        // 습도
        tvHumidity.text = humidity + "%"
        // 하능 상태
        result = ""
        when(sky) {
            "1" -> result = "맑음"
            "3" -> result = "구름 많음"
            "4" -> result = "흐림"
            else -> "오류"
        }
        tvSky.text = result
        // 온도
        tvTemp.text = temp + "°"
    }

    // 시간 설정하기
    // 동네 예보 API는 3시간마다 현재시각+4시간 뒤의 날씨 예보를 보여줌
    // 따라서 현재 시간대의 날씨를 알기 위해서는 아래와 같은 과정이 필요함. 자세한 내용은 함께 제공된 파일 확인
    fun getTime(time : String) : String {
        var result = ""
        when(time) {
            in "00".."02" -> result = "2000"    // 00~02
            in "03".."05" -> result = "2300"    // 03~05
            in "06".."08" -> result = "0200"    // 06~08
            in "09".."11" -> result = "0500"    // 09~11
            in "12".."14" -> result = "0800"    // 12~14
            in "15".."17" -> result = "1100"    // 15~17
            in "18".."20" -> result = "1400"    // 18~20
            else -> result = "1700"             // 21~23
        }
        return result
    }



}
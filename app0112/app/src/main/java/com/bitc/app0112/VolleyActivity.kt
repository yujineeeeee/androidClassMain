package com.bitc.app0112

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bitc.app0112.databinding.ActivityVolleyBinding
import com.google.gson.Gson
import com.google.gson.JsonObject
import org.json.JSONObject

class VolleyActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityVolleyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val queue = Volley.newRequestQueue(this)

        binding.btnVolleyRequest.setOnClickListener {
            val url = binding.etServerUrl.text.toString()

            var stringRequest = StringRequest(
                Request.Method.GET,
                url,
                Response.Listener<String>{
                    Log.d("csy-Volley", "서버 데이터 받아옴")
                    binding.tvVolley.text = it
                    Log.d("csy-volley", it)
                },
                Response.ErrorListener { error -> Log.d("csy-volley", "error : $error")}
            )

            queue.add(stringRequest)
        }

        binding.btnVolleyRequestJson.setOnClickListener {
            val url = binding.etServerUrl.text.toString()

            val gson = Gson()

//            Volley의 JsonObjectRequest() 사용 시 서버에 파라미터 전달 시 JSONObject 객체를 전달할 수 있음
//            JSONObject 객체를 생성 후 append()로 데이터를 추가하고
//            Volley의 JsonObjectRequest() 메소드의 3번째 매개변수로 JSONObject 객체를 전달
            var jsonObject: JSONObject = JSONObject()
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                jsonObject.append("title", "슬램덩크")
                jsonObject.append("rank", 1)
            }

//            json 타입으로 데이터 가져오기
//            서버에 안넘길때는 3번째 매개변수 null 하면 됨
            val jsonRequest = JsonObjectRequest(
                Request.Method.GET,
                url,
//                json 방식으로 서버에 데이터 전달 시 사용하는 부분 (json 객체 넣어주면 됨)
                jsonObject,
                Response.Listener<JSONObject> {
                    Log.d("csy-volley", "json 방식으로 데이터 가져오기 성공")
                    val data = it

                    var kobis: Kobis = gson.fromJson(it.toString(), Kobis::class.java)

                    val dailyBoxOfficeList = kobis.boxOfficeResult?.dailyBoxOfficeList

                    for(item in dailyBoxOfficeList!!){
                        Log.d("csy-volley", "제목 : ${item.movieNm}")
                    }
//                    Log.d("csy-volley", "${kobis.boxOfficeResult?.dailyBoxOfficeList?.get(0)?.movieNm}")
                },
                Response.ErrorListener { error ->
                    Log.d("csy-volley", "json 방식으로 데이터 가져오기 오류\nerror : $error")
                }
            )

            queue.add(jsonRequest)
        }

        binding.btnVolleyUrlClear.setOnClickListener {
            binding.etServerUrl.setText("")
        }
    }
}
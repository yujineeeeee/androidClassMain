package com.bitc.app0112

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneStateListener
import android.telephony.ServiceState
import android.telephony.SubscriptionInfo
import android.telephony.SubscriptionManager
import android.telephony.TelephonyCallback
import android.telephony.TelephonyManager
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import com.bitc.app0112.databinding.ActivityPhoneStateBinding

class PhoneStateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        val binding = ActivityPhoneStateBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        전화 상태정보 가져오기
//        안드로이드 시스템의 서비스 중 TelephonyManager 타입의 객체를 가져옴
        val manager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

//        API 31 이상부터 사용
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
//            TelephonyManager 에 콜백 메소드 추가
            manager.registerTelephonyCallback(
//                쓰레드에서 동작하도록 설정 (메인 쓰레드)
                mainExecutor,
//                TelephonyCallback() 클래스를 상속받아 구현함
                object : TelephonyCallback(), TelephonyCallback.CallStateListener{
//                    전화 상태 정보가 변경 시 자동 동작
                    override fun onCallStateChanged(state: Int) {
                        when(state) {
                            TelephonyManager.CALL_STATE_IDLE -> Log.d("csy-phoneState", "대기중")
                            TelephonyManager.CALL_STATE_OFFHOOK -> Log.d("csy-phoneState", "통화종료")
                            TelephonyManager.CALL_STATE_RINGING -> Log.d("csy-phoneState", "연결중")
                        }
                    }
                }
            )
        }




        binding.btnStateListenOn.setOnClickListener {
            if(isNetworkAvailable()){
                Log.d("csy-phoneState", "네트워크 접속 가능")
            }
            else {
                Log.d("csy-phoneState", "네트워크 접속 불가")
            }
        }

        binding.btnStateListenOff.setOnClickListener {

        }

    }

    private fun isNetworkAvailable() : Boolean{
//        안드로이드 시스템의 서비스로  ConnectivityManager 타입의 객체 생성
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
//            현재 네트워크 상태 확인
            val nw = connectivityManager.activeNetwork ?: return false // 3항 연산자
//            사용하고 있는 네트워크 종류 가져오기
            val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
//            사용하는 네트워크 종류 확인 후 결과 출력
            return when{
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    Log.d("csy-network", "WIFI 사용")
                    true
                }
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    Log.d("csy-network", "모바일 데이터 사용")
                    true
                }
                else -> false
            }
        }
        else{
            return connectivityManager.activeNetworkInfo?.isConnected ?: false
        }
    }
}
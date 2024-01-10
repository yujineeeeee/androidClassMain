package com.bitc.app0110

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    lateinit var myBinder: MyBinder

    override fun onCreate() {
        super.onCreate()
        Log.d("csy-bindService", "바인드 서비스 객체 생성")
        myBinder = MyBinder("Myservice의 onBind() 실행함")
    }

    override fun onBind(intent: Intent): IBinder {
        Log.d("csy-bindService", "바인드 서비스 동작")


        Log.d("csy-bindService", "가져온 데이터 : ${myBinder.msg}")

//        return MyBinder("MyService의 onBind() 실행함")
        return myBinder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d("csy-bindService", "바인드 서비스 종료")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("csy-bindService", "바인드 서비스 삭제")
    }
}
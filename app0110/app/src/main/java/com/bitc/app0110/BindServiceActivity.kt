package com.bitc.app0110

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import android.util.Log
import com.bitc.app0110.databinding.ActivityBindServiceBinding

class BindServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBindServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        안드로이드 API 에서 제공하는 IBinder 를 상속받아 구현한 클래스
        lateinit var messenger: Messenger

        val connection: ServiceConnection = object : ServiceConnection{
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                Log.d("csy-bind", "onServiceConnected 실행됨")

                val serviceBinder = service as MyBinder
                Log.d("csy-bind", "onBind()에서 전달한 데이터 : ${serviceBinder.msg}")

                serviceBinder.sendData("onServiceConnected 에서 전달한 데이터")
            }

            override fun onServiceDisconnected(name: ComponentName?) {

            }
        }

//        bindService()를 실행 시 연결되는 SerivceConnection 타입의 변수 선언
        val connection2 = object : ServiceConnection{
//            서비스 동작 시자동 실행되는 메소드
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
//                매개변수로 넘어오는 IBinder 타입의 객체를 Messenger 객체의 매개변수로 사용하여 Messenger 객체를 생성
                messenger = Messenger(service)
            }

            override fun onServiceDisconnected(name: ComponentName?) {

            }
        }

        binding.btnBindServiceStart.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }

        binding.btnBindServiceStop.setOnClickListener {
            unbindService(connection)
        }

        binding.btnBindServiceStart2.setOnClickListener {
//            인텐트 생성
            var intent = Intent(this, MyService2::class.java)
//            bindService() 로 서비스 시작
            bindService(intent, connection2, Context.BIND_AUTO_CREATE)
        }

        binding.btnBindServiceSend2.setOnClickListener {
//            서비스로 데이터를 전달하기 위한 데이터 셋팅
            val msg = Message()
            msg.what = 10
            msg.obj = "hello"
//            send() 메소드를 사용하여 서비스로 데이터 전달
            messenger.send(msg)
        }
    }
}
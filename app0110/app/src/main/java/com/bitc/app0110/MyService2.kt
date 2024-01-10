package com.bitc.app0110

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message
import android.os.Messenger
import android.widget.Toast

class MyService2 : Service() {
//    Messenger 클래스 타입의 변수 선언
    lateinit var messenger: Messenger

    //    internal : 자바의 default와 같음
//    첫번째 매개변수는 Context 타입의 데이터를 받음(앱의 현재 정보 받아오기), 매개변수일 뿐임
//    두번째 매개변수는 Context 타입의 데이터를 받음, val 키워드가 있으므로 해당 클래스의 필드가 됨
//    기본값을 가지고 있는 매개변수가 됨 (첫번째 매개변수를 두번째 매개변수의 기본 값으로 사용함)
//    기본값을 가지고 있는 매개변수는 객체 생성 시 생략 가능
    internal class IncomingHandler(context: Context, private val applicationContext: Context = context.applicationContext) : Handler(Looper.getMainLooper()){
//        이벤트 발생 시 동작하는 콜백함수 오버라이딩
//        send() 메소드 실행 시 자동 동작하는 메소드
        override fun handleMessage(msg: Message) {
//            받아온 데이터의 내용 비교
            when (msg.what){
                10 -> Toast.makeText(applicationContext, "${msg.obj}", Toast.LENGTH_SHORT).show()
                20 -> Toast.makeText(applicationContext, "${msg.obj}", Toast.LENGTH_SHORT).show()
                else -> super.handleMessage(msg)
            }
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        messenger = Messenger(IncomingHandler(this))
        return messenger.binder
    }
}
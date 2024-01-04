package com.bitc.app0104

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.RemoteInput

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
//        알림의 RemoteInput 을 통해서 전달된 데이터를 RemoteInput 객체 생성 시 등록한 키를 사용해서 가져옴
        val receiverText = RemoteInput.getResultsFromIntent(intent)?.getCharSequence("csy-receive")
        Log.d("csy-remote", "알림창에서 입력한 내용 : $receiverText")

//        안드로이드 시스템의 알림 서비스 정보를 NotificationManager 타입으로 가져옴
        val manager = context.getSystemService(AppCompatActivity.NOTIFICATION_SERVICE) as NotificationManager
//        등록된 알림 정보 중 지정한 키값으로 등록된 알림을 취소+
        manager.cancel(11)
    }
}
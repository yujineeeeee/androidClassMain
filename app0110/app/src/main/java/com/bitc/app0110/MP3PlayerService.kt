package com.bitc.app0110

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.widget.Toast

// Service 클래스를 상속 받아 사용자 서비스 클래스  파일 생성
class MP3PlayerService : Service() {

//    음악 파일을 재생하기 위해 안드로이드에서 기본 제공하는 API
    var mediaPlayer: MediaPlayer? = null

//    IBinder 를 상속받아 구현한 MP3PlayerBinder 클래스 타입의 객체 생성
    var mp3PlayerBinder: MP3PlayerBinder = MP3PlayerBinder()

//    내장 클래스로 선언
    inner class MP3PlayerBinder: Binder() {
//        MP3PlayerService 타입을 반환
        fun getService() : MP3PlayerService{
//            MP3PlayService 객체 자신을 반환
            return this@MP3PlayerService
        }
    }

//    bindService() 실행 시 동작하는 메소드
    override fun onBind(intent: Intent): IBinder {
        return mp3PlayerBinder
    }

//    mp3 파일 재생
    fun play() {
//        mediaPlayer 객체가 null 인지 확인
        if (mediaPlayer == null){
//            MediaPlayer 객체 생성
            mediaPlayer = MediaPlayer.create(this, R.raw.chocolate)
            mediaPlayer?.setVolume(1.0f, 1.0f) // 볼륨 설정
            mediaPlayer?.isLooping = true // 반복할건지 확인
//            지정한 mp3 파일 재생
            mediaPlayer?.start()
        }
//        mediaPlayer 객체가 있을 경우
        else{
//            현재 mp3 파일이 재생중인지 확인
            if(mediaPlayer!!.isPlaying){
                Toast.makeText(this, "이미 음악이 재생중입니다.", Toast.LENGTH_SHORT).show()
            }
            else{
                mediaPlayer?.start()
            }
        }
    }

//    재생 중지
    fun stop() {
        mediaPlayer?.let {
            if (it.isPlaying){
                it.stop()
                it.release()
                mediaPlayer = null
            }
        }
    }

//    재생 일시 정지
    fun pause(){
        mediaPlayer?.let {
            if(it.isPlaying){
                it.pause()
            }
            else{
                it.start()
            }
        }
    }
}
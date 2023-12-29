package com.bitc.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.bitc.myapplication.databinding.ActivityTouchBinding

class TouchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTouchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.view.setOnTouchListener{ v, event ->
            when (event.action){
                MotionEvent.ACTION_MOVE -> {
//                    해당 태그에 터치 이벤트를 정의해야 x, y, rawX, rawY의 값이 서로 다르게 표시 됨
//                    x, y : 이벤트가 발생한 태그의 x,y 좌표를 출력
//                    rawX, rawY : 전체 화면에서 이벤트가 발생한 x, y 좌표
                    Log.d("csy", "Touch move event x : ${event.x}, y : ${event.y}, rawX : ${event.rawX}, rawY =  ${event.rawY}")
                }
            }
            true
        }

//       뒤로가기 이벤트 메소드를 미리 만들어 놓고 등록하는 방식
        onBackPressedDispatcher.addCallback(this, callback)

//        익명 메소드(뒤로가기 이벤트 메소드) 를 콜백 메소드로 등록하는 방식
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                Log.d("csy_key", "신규 버전 뒤로 가기 버튼 클릭")
            }
        })
    }

//    터치와 관련된 이벤트 정보를 엑티비티에서 받으려면 onTouchEvent 메소드를 오버라이딩 해야 함
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action){
            MotionEvent.ACTION_DOWN -> {
                Toast.makeText(this@TouchActivity, "터치 다운 이벤트", Toast.LENGTH_SHORT).show()
            }
            MotionEvent.ACTION_UP -> {
                Toast.makeText(this@TouchActivity, "터치 업 이벤트", Toast.LENGTH_SHORT).show()
            }
            MotionEvent.ACTION_MOVE -> {
                Log.d("csy", "Touch move event x : ${event.x}, y : ${event.y}, rawX : ${event.rawX}, rawY =  ${event.rawY}")
            }
        }

        return super.onTouchEvent(event)
    }

//    키 이벤트 사용 시 사용할 키 이벤트의 메소드를 오버라이딩 해야 함
    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("csy", "키 업 이벤트")
        Toast.makeText(this@TouchActivity, "키 업 이벤트", Toast.LENGTH_SHORT).show()
        return super.onKeyUp(keyCode, event)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        Log.d("csy", "키 다운 이벤트")
        Toast.makeText(this@TouchActivity, "키 다운 이벤트", Toast.LENGTH_SHORT).show()

        when (keyCode){
            KeyEvent.KEYCODE_0 -> Log.d("csy_key","0 키를 눌렀습니다.")
            KeyEvent.KEYCODE_A -> Log.d("csy_key","A 키를 눌렀습니다.")
        }
        return super.onKeyDown(keyCode, event)
    }

//    API 32까지의 뒤로 가기 버튼 이벤트
//    override fun onBackPressed() {
//        Log.d("csy_key" "Back Button 누름")
//        super.onBackPressed()
//    }

//  콜백 메소드로 등록할 뒤로가기 이벤트 메소드를 미리 생성 (API 33 이상)
    private val callback = object: OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            Log.d("csy_key", "신규 버전 바로가기 ")
        }
    }
}
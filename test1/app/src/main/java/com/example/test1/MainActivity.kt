package com.example.test1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test1.databinding.ActivityMainBinding

// 해당 화면에서 연산을 진행하는 파일
// spring 프로젝트에서 controller + service 의 역할을 하는 파일

// AppCompatActivity 를 상속받아 사용
class MainActivity : AppCompatActivity() {
    //    상속받은 onCreate() 메소드를 오버라이딩하여 사용
    override fun onCreate(savedInstanceState: Bundle?) {
//        부모 객체의 onCreate 메소드 실행
        super.onCreate(savedInstanceState)

////    setContentView(리소스) : UI 파일과 연동하여 화면에 출력하는 메소드
////    R : 안드로이드 프로젝트의 리소스 객체
//        setContentView(R.layout.activity_main)
//
////        layout 파일에서 TextView 를 찾아옴
//        val textView: TextView = findViewById(R.id.textView)
////        찾아온 TextView의 속성 중 text 속성값을 변경
//        textView.text = "안녕하세요"

//        view binding 방식으로 layout 파일 자동 파싱
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.text = "view binding 으로 TextView 의 text 값 변경"
    }
}

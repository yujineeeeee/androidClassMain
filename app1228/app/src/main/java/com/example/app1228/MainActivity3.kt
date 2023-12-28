package com.example.app1228

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.app1228.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        기존 방식
//        setContentView(R.layout.activity_main3)
//
//        val btn1 = findViewById<Button>(R.id.btn1)
//
//        btn1.setOnClickListener {
//            btn1.text = "BUTTON 1"
//        }


//        뷰 바인딩 방식
        val binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        뷰 바인딩을 사용하여 미리 모든 태그의 ID를 가져왔기 때문에 필요한 태그의 ID를 입력하면 바로 사용할 수 있음
//        binding.id명
        binding.btn1.setOnClickListener {
//            EditText의 id인 edText1을 사용하여 사용자가 입력한 text를 가져옴
            val text = binding.edText1.text
//            토스트 메시지 출력
            Toast.makeText(this@MainActivity3, text, Toast.LENGTH_SHORT).show()
        }
    }
}
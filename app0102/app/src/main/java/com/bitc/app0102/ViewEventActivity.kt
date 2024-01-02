package com.bitc.app0102

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import android.widget.Toast
import com.bitc.app0102.databinding.ActivityViewEventBinding

class ViewEventActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityViewEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        엑티비티에서 인터페이스를 상속받은 후 인터페이스를 구현하여 실행
        binding.checkBox1.setOnCheckedChangeListener(this)
//        인터페이스를 상속받는 다른 클래스를 생성 후 해당 클래스를 구현하여 실행
        binding.checkBox2.setOnCheckedChangeListener(MyEventHandler())
//        SAM 방식으로 람다 함수를 사용하여 실행
        binding.checkBox3.setOnCheckedChangeListener {
            compoundButton, b -> Toast.makeText(this, "세번째 체크 박스 클릭 (b: $b)", Toast.LENGTH_SHORT).show()
        }

//        클릭 이벤트
        binding.button1.setOnClickListener {
            Toast.makeText(this, "클릭 이벤트 발생", Toast.LENGTH_SHORT).show()
        }
//        롱 클릭 이벤트
        binding.button2.setOnLongClickListener {
            Toast.makeText(this, "롱 클릭 이벤트 발생", Toast.LENGTH_SHORT).show()
//            롱 클릭 이벤트는 마지막에 Boolean 값을 반환해야 함
            true
        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        Toast.makeText(this, "첫번째 체크박스 클릭", Toast.LENGTH_SHORT).show()
    }
}

class MyEventHandler: CompoundButton.OnCheckedChangeListener{
    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        Log.d("csy", "두번째 체크 박스 클릭")
    }
}
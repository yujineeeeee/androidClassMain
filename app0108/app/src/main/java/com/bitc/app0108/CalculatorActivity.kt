package com.bitc.app0108

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.bitc.app0108.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {

    private val requestLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == RESULT_OK){
            val result = it.data?.getIntExtra("result", 0)
            binding.editTextResult.setText(result.toString())
            Toast.makeText(this, "연산 결과가 나왔습니다.", Toast.LENGTH_SHORT).show()
        }
        else if(it.resultCode == RESULT_CANCELED){
            Toast.makeText(this, "연산이 취소되었습니다.", Toast.LENGTH_SHORT).show()
        }
        else{

        }
    }

//    뷰 바인딩을 하기 위한 변수를 클래스의 필드로 선언
    lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        onCreate 메소드에서 뷰 바인딩 동작
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        eventInit()
    }

    private fun eventInit(){
        binding.btnCalProcess.setOnClickListener {
            val intent = Intent(this, ProcessingActivity::class.java) // 정보를 넘길 부분

            intent.putExtra("num1", binding.editTextNum1.text.toString())
            intent.putExtra("num2", binding.editTextNum2.text.toString())

            requestLauncher.launch(intent)
        }
    }
}
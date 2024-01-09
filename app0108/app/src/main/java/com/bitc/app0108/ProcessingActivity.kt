package com.bitc.app0108

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.app0108.databinding.ActivityProcessingBinding

class ProcessingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityProcessingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val processIntent = intent

        val strNum1 = processIntent.getStringExtra("num1")
        val strNum2 = processIntent.getStringExtra("num2")
        val num1 = strNum1!!.toInt()
        val num2 = strNum2!!.toInt()

        var result = 0

        binding.editTextNum1Process.setText(strNum1)
        binding.editTextNum2Process.setText(strNum2)

        binding.btnSum.setOnClickListener {
            result = num1 + num2
            intent.putExtra("result", result)
            setResult(RESULT_OK, intent)
            finish()
        }

        binding.btnSub.setOnClickListener {
            result = num1 - num2
            intent.putExtra("result", result)
            setResult(RESULT_OK, intent)
            finish()
        }

        binding.btnMulti.setOnClickListener {
            result = num1 * num2
            intent.putExtra("result", result)
            setResult(RESULT_OK, intent)
            finish()
        }

        binding.btnDiv.setOnClickListener {
            result = num1 / num2
            intent.putExtra("result", result)
            setResult(RESULT_OK, intent)
            finish()
        }

        binding.btnCancel.setOnClickListener {
            setResult(RESULT_CANCELED, intent)
            finish()
        }
    }
}
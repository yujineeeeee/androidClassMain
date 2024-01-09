package com.bitc.app0108

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bitc.app0108.databinding.ActivityIntentTest1Binding

class IntentTest1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityIntentTest1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var value1 = intent.getStringExtra("param1")
        var value2 = intent.getIntExtra("param2", 0)

        Toast.makeText(this, "첫번째 데이터 : $value1, 두번째 데이터 : $value2", Toast.LENGTH_SHORT).show()

        binding.btnIntentTest1Exit.setOnClickListener {
            finish()
        }
    }
}
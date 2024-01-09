package com.bitc.app0108

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.bitc.app0108.databinding.ActivityIntentTest2Binding

class IntentTest2Activity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityIntentTest2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val intentTest2 = intent

        val value3 = intentTest2.getStringExtra("param3")

        binding.textViewParam3.text = value3

        binding.btnIntentTest2Exit.setOnClickListener {
            val userText = binding.editTextUserText.text

            intentTest2.putExtra("resultParam", userText.toString())
            setResult(RESULT_OK, intentTest2)

            finish()
        }
    }
}
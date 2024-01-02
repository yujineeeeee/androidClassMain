package com.bitc.app0102

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.app0102.databinding.ActivityAndroidResourceBinding

class AndroidResourceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAndroidResourceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView2.text = getString(android.R.string.emptyPhoneNumber)
    }
}
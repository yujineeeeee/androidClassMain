package com.bitc.app0102

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.app0102.databinding.ActivityLandBinding

class LandActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLandBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
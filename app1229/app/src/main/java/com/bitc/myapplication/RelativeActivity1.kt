package com.bitc.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.myapplication.databinding.ActivityRelativeBinding

class RelativeActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRelativeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
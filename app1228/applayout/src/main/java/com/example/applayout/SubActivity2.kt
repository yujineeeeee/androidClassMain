package com.example.applayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.applayout.databinding.ActivitySub2Binding

class SubActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivitySub2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
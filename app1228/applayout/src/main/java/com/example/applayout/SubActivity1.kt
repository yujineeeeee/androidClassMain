package com.example.applayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.applayout.databinding.ActivitySub1Binding

class SubActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivitySub1Binding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}
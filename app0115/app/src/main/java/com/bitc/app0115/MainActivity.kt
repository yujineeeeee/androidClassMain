package com.bitc.app0115

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bitc.app0115.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
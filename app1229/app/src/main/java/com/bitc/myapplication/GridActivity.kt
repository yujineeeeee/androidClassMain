package com.bitc.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.myapplication.databinding.ActivityGridBinding
import com.bitc.myapplication.databinding.ActivityMainBinding

class GridActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityGridBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
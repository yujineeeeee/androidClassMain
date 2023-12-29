package com.bitc.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bitc.myapplication.databinding.ActivityFrameBinding

class FrameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityFrameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            binding.btn1.visibility = View.INVISIBLE
            binding.img1.visibility = View.VISIBLE
        }

        binding.img1.setOnClickListener{
            binding.img1.visibility = View.INVISIBLE
            binding.btn1.visibility = View.VISIBLE
        }
    }
}
package com.bitc.app0108

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.app0108.databinding.ActivityDrawerLayoutBinding

class DrawerLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDrawerLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
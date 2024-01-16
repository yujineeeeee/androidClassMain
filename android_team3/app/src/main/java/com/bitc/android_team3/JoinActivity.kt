package com.bitc.android_team3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.android_team3.databinding.ActivityJoinBinding

class JoinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}
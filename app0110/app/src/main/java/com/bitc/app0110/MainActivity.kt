package com.bitc.app0110

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.app0110.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBindService.setOnClickListener {
            val intent = Intent(this, BindServiceActivity::class.java)
            startActivity(intent)
        }

        binding.btnMp3Player.setOnClickListener {
            val intent = Intent(this, MP3Activity::class.java)
            startActivity(intent)
        }

        binding.btnProvider.setOnClickListener {
            val intent = Intent(this, ProviderActivity::class.java)
            startActivity(intent)

        }
    }
}
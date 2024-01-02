package com.bitc.app0102

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.app0102.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lateinit var intent: Intent

        binding.btnViewEvent.setOnClickListener {
            intent = Intent(this@MainActivity, ViewEventActivity::class.java)
            startActivity(intent)
        }

        binding.btnStopWatch.setOnClickListener {
            intent = Intent(this@MainActivity, StopWatchActivity::class.java)
            startActivity(intent)
        }

        binding.btnAndroidResource.setOnClickListener {
            intent = Intent(this@MainActivity, AndroidResourceActivity::class.java)
            startActivity(intent)
        }

        binding.btnLandView.setOnClickListener {
            intent = Intent(this@MainActivity, LandActivity::class.java)
            startActivity(intent)
        }
    }
}
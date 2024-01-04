package com.bitc.app0104

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.bitc.app0104.databinding.ActivityAlarmBinding
import com.bitc.app0104.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lateinit var intent: Intent

        binding.btnCustom.setOnClickListener {
            intent = Intent(this, AlertDialogActivity::class.java)
            startActivity(intent)
        }

        binding.btnAlarm.setOnClickListener {
            intent = Intent(this, AlarmActivity::class.java)
            startActivity(intent)
        }

        binding.btnKakao.setOnClickListener {
            intent = Intent(this, KakaoActivity::class.java)
            startActivity(intent)
        }
    }
}
package com.bitc.android_team3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.android_team3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoginActivity.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        var txt = ""
//        val userId = sharedPref.getString("id", "")
//        val userName = sharedPref.getString("name", "")
//        val userEmail = sharedPref.getString("email", "")
//        val userPhone = sharedPref.getString("phone", "")
//
//        txt += "아이디 : $userId\n"
//        txt += "이름 : $userName\n"
//        txt += "이메일 : $userEmail\n"
//        txt += "전화번호 : $userPhone\n"
//
//        binding.tvUserInfo.text = txt
    }
}
package com.bitc.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.myapplication.databinding.ActivityPhoneBinding

class PhoneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPhoneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var phoneNumber: String = ""

        binding.tv0.setOnClickListener {
            phoneNumber = binding.tvPhoneNumber.text as String
            phoneNumber += binding.tv0.text
            binding.tvPhoneNumber.text = phoneNumber
        }

        binding.tv1.setOnClickListener {
            phoneNumber = binding.tvPhoneNumber.text as String
            phoneNumber += binding.tv1.text
            binding.tvPhoneNumber.text = phoneNumber
        }

        binding.tv2.setOnClickListener {
            phoneNumber = binding.tvPhoneNumber.text as String
            phoneNumber += binding.tv2.text
            binding.tvPhoneNumber.text = phoneNumber
        }

        binding.tv3.setOnClickListener {
            phoneNumber = binding.tvPhoneNumber.text as String
            phoneNumber += binding.tv3.text
            binding.tvPhoneNumber.text = phoneNumber
        }

        binding.tv4.setOnClickListener {
            phoneNumber = binding.tvPhoneNumber.text as String
            phoneNumber += binding.tv4.text
            binding.tvPhoneNumber.text = phoneNumber
        }

        binding.tv5.setOnClickListener {
            phoneNumber = binding.tvPhoneNumber.text as String
            phoneNumber += binding.tv5.text
            binding.tvPhoneNumber.text = phoneNumber
        }

        binding.tv6.setOnClickListener {
            phoneNumber = binding.tvPhoneNumber.text as String
            phoneNumber += binding.tv6.text
            binding.tvPhoneNumber.text = phoneNumber
        }

        binding.tv7.setOnClickListener {
            phoneNumber = binding.tvPhoneNumber.text as String
            phoneNumber += binding.tv7.text
            binding.tvPhoneNumber.text = phoneNumber
        }

        binding.tv8.setOnClickListener {
            phoneNumber = binding.tvPhoneNumber.text as String
            phoneNumber += binding.tv8.text
            binding.tvPhoneNumber.text = phoneNumber
        }

        binding.tv9.setOnClickListener {
            phoneNumber = binding.tvPhoneNumber.text as String
            phoneNumber += binding.tv9.text
            binding.tvPhoneNumber.text = phoneNumber
        }

        binding.tvStar.setOnClickListener {
            phoneNumber = binding.tvPhoneNumber.text as String
            phoneNumber += binding.tvStar.text
            binding.tvPhoneNumber.text = phoneNumber
        }

        binding.tvSharp.setOnClickListener {
            phoneNumber = binding.tvPhoneNumber.text as String
            phoneNumber += binding.tvSharp.text
            binding.tvPhoneNumber.text = phoneNumber
        }

        binding.imgBack.setOnClickListener{
            phoneNumber = binding.tvPhoneNumber.text as String
            phoneNumber = phoneNumber.substring(0, phoneNumber.length -1)
            binding.tvPhoneNumber.text = phoneNumber
        }

    }
}
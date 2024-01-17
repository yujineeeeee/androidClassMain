package com.bitc.app0112

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.app0112.databinding.ActivityGlideBinding
import com.bumptech.glide.Glide

class GlideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityGlideBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGlideUse.setOnClickListener {
            val url = binding.etGlide.text.toString()

            Glide.with(this)
                .load(url)
                .override(500, 500)
                .placeholder(R.drawable.chorok)
                .error(R.drawable.chorok1)
                .into(binding.ivGlideImage)

            binding.etGlide.setText("")
        }
    }
}
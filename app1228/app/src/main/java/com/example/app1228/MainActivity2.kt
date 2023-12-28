package com.example.app1228

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btn1: Button = findViewById(R.id.btn1)
        btn1.setOnClickListener {
            btn1.visibility = View.INVISIBLE
        }

        val btn2: Button = findViewById(R.id.btn2)
        btn2.setOnClickListener {
            btn2.visibility = View.GONE
        }

        val btn3 = findViewById<Button>(R.id.btn3)
        btn3.setOnClickListener {
            btn1.visibility = View.VISIBLE
            btn2.visibility = View.VISIBLE
        }
    }
}
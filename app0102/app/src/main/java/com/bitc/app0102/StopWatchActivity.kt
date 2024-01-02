package com.bitc.app0102

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.os.SystemClock
import android.view.KeyEvent
import android.widget.Toast
import com.bitc.app0102.databinding.ActivityStopWatchBinding

class StopWatchActivity : AppCompatActivity() {
//    뒤로가기 버튼을 누른 시각을 저장하는 속성
    var initTime = 0L
//    멈춘 시각을 저장하는 속성
    var pauseTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityStopWatchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
            binding.chronometer.start()

            binding.btnStop.isEnabled = true
            binding.btnReset.isEnabled = true
            binding.btnStart.isEnabled = false
        }

//        binding.btnStop.text = "일시정지"
        binding.btnStop.setOnClickListener {
            pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime()
            binding.chronometer.stop()

            binding.btnStop.isEnabled = false
            binding.btnReset.isEnabled = true
            binding.btnStart.isEnabled = true
        }

        binding.btnReset.setOnClickListener {
            binding.btnReset.text = "리셋"
            pauseTime = 0L
            binding.chronometer.base = SystemClock.elapsedRealtime()
            binding.chronometer.stop()

            binding.btnStop.isEnabled = false
            binding.btnReset.isEnabled = false
            binding.btnStart.isEnabled = true
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(System.currentTimeMillis() - initTime > 3000){
                Toast.makeText(this, "종료하려면 한 번 더 누르세요", Toast.LENGTH_SHORT).show()
                initTime = System.currentTimeMillis()
                return true
            }
        }

        return super.onKeyDown(keyCode, event)
    }
}
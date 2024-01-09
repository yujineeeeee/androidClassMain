package com.bitc.app0109

import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.BatteryManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.bitc.app0109.databinding.ActivityBatteryBinding

class BatteryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBatteryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
                if (it.all { permission -> permission.value == true }) {
                    val intent = Intent(this, MyReceiver::class.java)
                    sendBroadcast(intent)
                } else {
                    Toast.makeText(this, "permission denied...", Toast.LENGTH_SHORT).show()
                }
            }

        registerReceiver(null, IntentFilter(Intent.ACTION_BATTERY_CHANGED))!!.apply {
            when (getIntExtra(BatteryManager.EXTRA_STATUS, -1)) {
                BatteryManager.BATTERY_STATUS_CHARGING -> {
                    when (getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)) {
                        BatteryManager.BATTERY_PLUGGED_USB -> {
                            binding.tvChargingResult.text = "USB Plugged"
                            binding.imgViewCharging.setImageBitmap(BitmapFactory.decodeResource(resources, R.drawable.usb))
                        }

                        BatteryManager.BATTERY_PLUGGED_AC -> {
                            binding.tvChargingResult.text = "AC Plugged"
                            binding.imgViewCharging.setImageBitmap(BitmapFactory.decodeResource(resources, R.drawable.ac))
                        }
                    }
                }
                else -> {
                    binding.tvChargingResult.text = "Not Plugged"
                }
            }

            val level = getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale = getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            val batteryPct = level / scale.toFloat() * 100
            binding.tvPercentResult.text = "$batteryPct %"
        }

        binding.btnRunReceiver.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                if (ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") == PackageManager.PERMISSION_GRANTED
                ) {
                    val intent = Intent(this, MyReceiver::class.java)
                    sendBroadcast(intent)
                } else {
                    permissionLauncher.launch(arrayOf("android.permission.POST_NOTIFICATION"))
                }

            } else {
                val intent = Intent(this, MyReceiver::class.java)
                sendBroadcast(intent)
            }
        }
    }
}
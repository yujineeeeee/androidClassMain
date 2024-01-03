package com.bitc.app0103

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.bitc.app0103.databinding.ActivityPermissionBinding

class PermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPermissionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                Log.d("csy-permission", "권한 주어짐")
            } else {
                Log.d("csy-permission", "권한 거부됨")
            }
        }

        permissionLauncher.launch("android.permission.ACCESS_FINE_LOCATION")

//        val status = ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION")
//
//        Log.d("csy-permission", "퍼미션 상태 : ${status.toString()}")
//
//        if(status == PackageManager.PERMISSION_GRANTED){
//            Log.d("csy-permission", "사용 권한 주어짐")
//        }
//        else{
//            Log.d("csy-permission", "사용 권한 거부됨")
//        }
    }
}
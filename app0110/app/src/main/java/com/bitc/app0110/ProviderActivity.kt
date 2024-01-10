package com.bitc.app0110

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.bitc.app0110.databinding.ActivityProviderBinding
import java.io.File
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.Date

class ProviderActivity : AppCompatActivity() {

    lateinit var binding: ActivityProviderBinding
    lateinit var filePath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProviderBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        사진첩 앱 사용 후 엑티비티가 종료될 경우 실행
//        사진첩 앱의 사용 결과를 가져옴
        val requestGalleryLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            try {
                val calRatio = calculateInSampleSize(
                    it.data!!.data!!,
                    resources.getDimensionPixelSize(R.dimen.imgSize),
                    resources.getDimensionPixelSize(R.dimen.imgSize)
                )
                val option = BitmapFactory.Options()
                option.inSampleSize = calRatio

//                contentResolver를 통해서 반환받은 데이터를 파싱
                var inputStream = contentResolver.openInputStream(it.data!!.data!!)
//                파싱된 데이터를 안드로이드 시스템에서 사용하는 이미지 형식으로 변환
                val bitmap = BitmapFactory.decodeStream(inputStream, null, option)
//                파싱한 데이터를 변환했으므로 스트림 닫기
                inputStream!!.close()
                inputStream = null

//                이미지 정보를 ImageView에 적용
                bitmap?.let {
                    binding.ivUser.setImageBitmap(bitmap)
                } ?: let {
                    Log.d("csy-provider", "이미지 없음")
                }
            }
            catch (e: Exception){
                e.printStackTrace()
            }
        }

        binding.btnGallery.setOnClickListener {
//            사진첩 앱에 접근
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
//            접근할 데이터의 타입 설정
            intent.type = "image/*"
//            Intent 에 사용 요청
            requestGalleryLauncher.launch(intent)
        }

//        카메라 앱 사용 후 결과를 반환하는 콜백 함수
        val requestCameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
//            이미지 크기 계산
            val calRatio = calculateInSampleSize(
                Uri.fromFile(File(filePath)),
                resources.getDimensionPixelSize(R.dimen.imgSize),
                resources.getDimensionPixelSize(R.dimen.imgSize)
                )

//            BitmapFactory에 이미지 크기 설정
            val option = BitmapFactory.Options()
            option.inSampleSize = calRatio
//            캡처한 내용을 파일로 저장
            val bitmap = BitmapFactory.decodeFile(filePath, option)
            bitmap?.let {
//                ImageView 태그에 캡처한 이미지를 적용
                binding.ivUser.setImageBitmap(bitmap)
            }
        }

        binding.btnCamera.setOnClickListener {
//            캡처한 파일의 이름을 현재 시간을 기준으로 지정
            val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
//            Environment 클래스는 시스템 정보를 가지고 있는 클래스
            val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
//            지정한 위치에 File 클래스로 파일 생성
            val file = File.createTempFile("JPEG_${timeStamp}_", ".jpg", storageDir)

            filePath = file.absolutePath
//            안드로이드 시스템에 저장할 파일 위치 설정
            val photoURI: Uri = FileProvider.getUriForFile(this, "com.bitc.app0110.fileprovider", file)

//            카메라 앱 실행
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//            안드로이드 시스템에 저장할 파일 위치 및 파일 이름을 putExtra로 intent에 전달함
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
//            intent 실행, 카메라 앱 실행
            requestCameraLauncher.launch(intent)
        }
    }

    private fun calculateInSampleSize(fileUri: Uri, reqWidth: Int, reqHeight: Int): Int {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true

        try {
            var inputStream = contentResolver.openInputStream(fileUri)
            BitmapFactory.decodeStream(inputStream, null, options)
            inputStream!!.close()
            inputStream = null
        }
        catch (e: Exception){
            e.printStackTrace()
        }

        val (height: Int, width: Int) = options.run {
            outHeight to outWidth
        }
        var inSampleSize = 1

        if(height > reqHeight || width > reqWidth){
            val halfHeight: Int = height / 2
            val halfWidth: Int = width / 2

            while (halfHeight / inSampleSize >= reqHeight && halfWidth / inSampleSize >= reqWidth){
                inSampleSize *= 2
            }
        }

        return inSampleSize
    }
}























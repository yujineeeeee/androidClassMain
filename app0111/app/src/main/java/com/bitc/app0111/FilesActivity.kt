package com.bitc.app0111

import android.content.Context
import android.icu.util.Output
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import com.bitc.app0111.databinding.ActivityFilesBinding
import java.io.BufferedReader
import java.io.File
import java.io.InputStream
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.OutputStreamWriter

class FilesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFilesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED){
            Log.d("csy-files", "외부 저장소 사용 가능")

        }
        else{
            Log.d("csy-files", "외부 저장소 사용 불가")
        }

        binding.btnSystemInFileWrite.setOnClickListener {
//            val file = File(filesDir, "test.txt")
//            val writeStream: OutputStreamWriter = file.writer()
//            writeStream.write("hello world!!" + "\n")
//            writeStream.write("안녕하세요")
//            writeStream.flush()
//            writeStream.close()

//            Context.MODE_PRIVATE : 기본 모드, 파일을 생성하고 쓰기 모드로 동작
//            Context.MODE_APPEND : 파일이 없으면 새로 만들고, 파일이 있으면 기존 파일에 추가하여 사용
            openFileOutput("test.txt", Context.MODE_PRIVATE).use {
                it.write("헬로월드!!".toByteArray()) // write 는 새로 생성하는 거라서 기존 파일 없어짐
            }
        }

        binding.btnSystemInFileRead.setOnClickListener {
//            val file = File(filesDir, "test.txt")
//            val readStream: BufferedReader = file.reader().buffered()
//            readStream.forEachLine {
//                Log.d("csy-file", "$it")
//            }

            openFileInput("test.txt").bufferedReader().forEachLine {
                Log.d("csy-file", "$it")
            }
        }

        binding.btnSystemOutFileWrite.setOnClickListener {
            val file: File = File(getExternalFilesDir(null), "test.txt")
            val writeStream: OutputStreamWriter = file.writer()
            writeStream.write("hello world!! \n")
            writeStream.write("두번째 hello world!! \n")
            writeStream.flush()
        }

        binding.btnSystemOutFileRead.setOnClickListener {
            val file: File = File(getExternalFilesDir(null), "test.txt")
            val readStream: BufferedReader = file.reader().buffered()
            readStream.forEachLine {
                Log.d("csy-files", "$it")
            }
        }

    }
}
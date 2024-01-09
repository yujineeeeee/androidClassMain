package com.bitc.app0108

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bitc.app0108.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        출력할 데이터 만듦
        val items = mutableListOf<String>()
        for (i in 1..20){
            items.add("Item $i")
        }

//        현재 엑티비티의 리사이클러 뷰에 사용할 layout 을 지정함
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        현재 엑티비티의 리사이클러 뷰 UI에 adapter 연동, MyAdapter 클래스의 객체 생성, 생성자의 매개변수에 만들어진 데이터 전달
        binding.recyclerView.adapter = MyAdapter(items)
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }
}
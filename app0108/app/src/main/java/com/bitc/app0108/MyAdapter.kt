package com.bitc.app0108

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bitc.app0108.databinding.ItemMainBinding

// xml 파일을 파싱한 ViewHolder 를 여러개 가지는 Adapter 클래스
// 매개변수로 리사이클러 뷰에 표시할 데이터를 받아옴
class MyAdapter(private val items: MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

//    ViewHolder가 생성될 때 실행됨, 전체 UI를 생성함
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

//    ViewHolder 의 수를 반환
    override fun getItemCount(): Int {
        return items.size
    }

//    생성된 리사이클러 뷰의 ViewHolder 에 데이터를 연동
//    첫번째 매개변수로 RecyclerView.ViewHolder 타입의 객체를 가져옴, RecyclerView.ViewHolder 의 객체 안에 들어있는 것은 자식클래스 타입의 객체인 MyViewHolder 가 들어있음
//    두번째 매개변수는 MyAdapter 클래스 타입의 객체를 생성 시 받아온 데이터의 index 번호
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("csy-recycler", "onBindViewHolder : $position")

//    자식 클래스 타입의 객체로 강제 타입 변환, 자식 클래스 타입의 객체가 가지고 있던 태그 정보를 변수에 저장
        val binding = (holder as MyViewHolder).binding
        binding.itemData.text = items[position]

        binding.itemData.setOnClickListener {
            Log.d("csy-recycler", "item root Click : $position")
        }
    }

}


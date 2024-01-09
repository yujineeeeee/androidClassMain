package com.bitc.app0108

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bitc.app0108.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var items = mutableListOf<ChatData>()
        for(i in 1..5 ){
            items.add(ChatData("사람 $i", "내용 $i", "2024-01-0$i"))
        }

        val chatAdapter = ChatAdapter(items)

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

//        chatRecyclerView : item_chat의 RecyclerView 아이디
        binding.chatRecyclerView.layoutManager = linearLayoutManager
        binding.chatRecyclerView.adapter = chatAdapter
        binding.chatRecyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        binding.btnRecyclerViewAdd.setOnClickListener {
            items.add(ChatData("홍길동", "안녕하세요. 홍길동입니다", "2024-01-08 12:34"))
            chatAdapter.notifyDataSetChanged()
        }

        binding.btnRecyclerViewRemove.setOnClickListener {
            items.removeAt(items.size - 1)
            chatAdapter.notifyDataSetChanged()
        }
    }
}
package com.bitc.app0108

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bitc.app0108.databinding.ItemChatBinding

data class ChatData(val name: String, val contents: String, val date: String)

class ChatAdapter(private val items: MutableList<ChatData>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ChatViewHolder(ItemChatBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as ChatViewHolder).binding
        binding.tvName.text = items[position].name
        binding.tvContent.text = items[position].contents
        binding.tvDate.text = items[position].date
    }
}
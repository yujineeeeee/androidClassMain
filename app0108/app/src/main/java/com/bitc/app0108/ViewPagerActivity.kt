package com.bitc.app0108

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.bitc.app0108.databinding.ActivityViewPagerBinding

class ViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        뷰 페이저2에 사용할 프래그먼트 리스트 생성
        val fragmentList = listOf<Fragment>(OneFragment(), TwoFragment(), ThreeFragment())
//        뷰 페이저2 어뎁터 객체 생성
        val viewPager2Adapter = ViewPager2Adapter(this)

//        뷰 페이저2 어뎁터에 사용할 프래그먼트 리스트 등록
        viewPager2Adapter.fragmentList = fragmentList
//        뷰 페이저2 에 어뎁터 등록
        binding.viewPager2.adapter = viewPager2Adapter
    }
}
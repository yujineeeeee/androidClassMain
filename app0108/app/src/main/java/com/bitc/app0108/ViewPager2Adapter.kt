package com.bitc.app0108

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

// 뷰 페이저2 는 FragmentStateAdapter 를 상속 받아 사용
// 현재 엑티비티를 매개변수로 받아서 사용
class ViewPager2Adapter(fa: FragmentActivity): FragmentStateAdapter(fa) {
    var fragmentList = listOf<Fragment>()

//    등록된 프래그먼트의 수 출력
    override fun getItemCount(): Int {
        return fragmentList.size
    }

//    프래그먼트 리스트의 수 만큼 뷰 페이저에서 사용할 프래그먼트를 생성
    override fun createFragment(position: Int): Fragment {
        return fragmentList.get(position)
    }
}
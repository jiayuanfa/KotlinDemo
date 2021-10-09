package com.example.kotlindemo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


/**
 * <pre>
 *     author: Jafar
 *     date  : 2021/10/8
 *     desc  :
 * </pre>
 */
internal class CustomAdapterFragmentPager(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    val PAGE_HOME = 0
    val PAGE_FIND = 1
    val PAGE_INDICATOR = 2
    val PAGE_OTHERS = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            PAGE_HOME -> HomeFragment()
            PAGE_FIND -> PageFragment()
            PAGE_INDICATOR -> IndicatorFragment()
            else -> IndicatorFragment()
        }
    }

    override fun getItemCount(): Int {
        return 4
    }
}

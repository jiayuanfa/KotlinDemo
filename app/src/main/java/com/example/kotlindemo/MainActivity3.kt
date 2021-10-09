package com.example.kotlindemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

/**
 * TabLayout与ViewPage2与Fragment相结合
 */
class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        initViewPage2()
    }

    private fun initViewPage2() {

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager)

        val adapter = CustomAdapterFragmentPager(this)
        viewPager2.adapter = adapter
        val titles = arrayListOf(1, 2, 3)

        titles.forEachIndexed { index, i ->
            tabLayout.addTab(tabLayout.newTab())
            tabLayout.getTabAt(index)?.text = i.toString()
        }

        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL    // 设置滚动方向
        // 注册滑动监听回调
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                println("滑动到了$position")
                tabLayout.getTabAt(position)?.select()
            }
        })
        viewPager2.isUserInputEnabled = true   // 禁止用户滑动

        TabLayoutMediator(
            tabLayout, viewPager2
        ) { tab, position ->
        }
    }
}
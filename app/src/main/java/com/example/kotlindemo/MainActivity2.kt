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
 * TabLayout与ViewPage2相结合
 */
class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        initViewPage2()
    }

    private fun initViewPage2() {

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager)

        val myAdapter = MyAdapter()
        val titles = arrayListOf(1, 2, 3)

        titles.forEachIndexed { index, i ->
            tabLayout.addTab(tabLayout.newTab())
            tabLayout.getTabAt(index)?.text = titles[index].toString()
        }
        myAdapter.setList(titles)

        viewPager2.adapter = myAdapter
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
            tab.text = titles[position].toString()
        }

        // 缩放效果
//        val compositePageTransformer = CompositePageTransformer()
//        compositePageTransformer.addTransformer(ScaleInTransformer())
//        compositePageTransformer.addTransformer(MarginPageTransformer(10))
//        viewPager2.setPageTransformer(compositePageTransformer)

        // 一屏多页 通过设置Padding实现
        val recyclerView = viewPager2.getChildAt(0) as RecyclerView
        val padding = 100
        recyclerView.setPadding(padding, 0, padding, 0)
        recyclerView.clipToPadding = false

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(ScaleInTransformer())
        compositePageTransformer.addTransformer(MarginPageTransformer(50))
        viewPager2.setPageTransformer(compositePageTransformer)

    }
}
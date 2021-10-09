package com.example.kotlindemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewPage2()
    }

    private fun initViewPage2() {
        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager)
        val myAdapter = MyAdapter()
        myAdapter.setList(arrayListOf(1, 2, 3))
        viewPager2.adapter = myAdapter
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL    // 设置滚动方向
        // 注册滑动监听回调
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                println("滑动到了$position")
            }
        })
        viewPager2.isUserInputEnabled = true   // 禁止用户滑动

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
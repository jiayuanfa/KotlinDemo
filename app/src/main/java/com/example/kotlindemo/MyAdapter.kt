package com.example.kotlindemo

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


/**
 * <pre>
 *     author: Jafar
 *     date  : 2021/10/8
 *     desc  :
 * </pre>
 */
class MyAdapter : RecyclerView.Adapter<MyAdapter.PagerViewHolder>() {

    private var mList: List<Int>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false)
        return PagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bindData(position)
    }

    override fun getItemCount(): Int {
        return mList!!.size
    }

    fun setList(list: List<Int>) {
        mList = list
    }

    inner class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mTextView: TextView = itemView.findViewById(R.id.tv_text)
        private val colors = arrayOf("#CCFF99", "#41F1E5", "#8D41F1", "#FF99CC")
        fun bindData(index: Int) {
            mTextView.text = index.toString()
            mTextView.setBackgroundColor(Color.parseColor(colors[index]))
        }
    }
}

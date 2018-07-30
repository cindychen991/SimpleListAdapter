package com.chendandan.listadapter

import android.app.Activity
import android.os.Bundle
import com.chendandan.listadapter.adapter.ListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    private lateinit var list: MutableList<String>
    private lateinit var adapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }


    private fun initView() {
        list = mutableListOf()
        adapter = ListAdapter(this, list)
        listView.adapter = adapter
    }

    private fun initData() {
        var size = 0
        while (size <= 8) {
            list.add("Hi! It's $size")
            size += 1
        }
        adapter.notifyDataSetChanged()
    }
}

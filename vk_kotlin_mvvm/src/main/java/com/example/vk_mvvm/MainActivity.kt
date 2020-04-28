package com.example.vk_mvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val viewModel: NewsViewModel by viewModels()
    private var adapter: NewsListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindView()
        setAdapter()
        setNews()
    }

    private fun bindView() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    private fun setAdapter() {
        adapter = NewsListAdapter()
        recyclerView.adapter = adapter

        adapter?.setOnItemClickListener(onItemClickListener = object :
            OnItemClickListener {
            override fun onItemClick(position: Int, view: View) {
                val intent = Intent(baseContext, NewsDetailActivity::class.java)
                intent.putExtra("post_id", adapter?.getItem(position)?.id)
                startActivity(intent)
            }
        })
    }

    private fun setNews() {
        viewModel.loadNews()
        viewModel.liveData.observe(this, Observer { result ->
            when (result) {
                is NewsViewModel.State.Result -> {
                    adapter?.addItems(result.newsList)
                }
            }
        })
    }
}
package com.example.vkkotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vkkotlin.NewsListAdapter.ItemClickListener


class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var adapter: NewsListAdapter? = null

    private var listener: ItemClickListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listener = object : ItemClickListener {
            override fun itemClick(position: Int, item: News?) {
                val intent = Intent(applicationContext, NewsDetailActivity::class.java)
                intent.putExtra("news", item)
                startActivity(intent)
            }
        }
        NewsContents.create()
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(applicationContext)
        adapter = NewsListAdapter(
            NewsContents.getNews(),
            listener,
            applicationContext
        )
        recyclerView!!.adapter = adapter
    }
}

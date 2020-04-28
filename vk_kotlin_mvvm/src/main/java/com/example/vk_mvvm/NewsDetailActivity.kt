package com.example.vk_mvvm

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlin.properties.Delegates

class NewsDetailActivity : AppCompatActivity() {

    private lateinit var postName: TextView
    private lateinit var postDate: TextView
    private lateinit var postText: TextView
    private lateinit var postCommentsCount: TextView
    private lateinit var postLikesCount: TextView
    private lateinit var postSharesCount: TextView
    private lateinit var postViewsCount: TextView
    private lateinit var likedByPeople: TextView
    private lateinit var postImage: ImageView
    private lateinit var icon: ImageView
    private lateinit var backButton: ImageView
    private var postId by Delegates.notNull<Int>()
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        postId = intent.getIntExtra("post_id", 1)
        bindView()
        setData()
    }

    private fun bindView() {
        postName = findViewById(R.id.author)
        postDate = findViewById(R.id.date)
        postText = findViewById(R.id.contentText)
        postCommentsCount = findViewById(R.id.comment)
        postLikesCount = findViewById(R.id.like)
        postSharesCount = findViewById(R.id.share)
        postViewsCount = findViewById(R.id.view_text)
        likedByPeople = findViewById(R.id.likedbypeople)
        postImage = findViewById(R.id.imageView3)
        icon = findViewById(R.id.imageView)
        backButton = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            onBackPressed()
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        return
    }
    private fun setData() {
        viewModel.searchNews(newsId = postId)
        viewModel.liveData.observe(this, Observer { result ->
            when (result) {
                is NewsViewModel.State.SearchResult -> {
                    setView(result.news)
                }
            }
        })
    }

    private fun setView(news: News) {
        postName.text = news.name
        postDate.text = news.date
        postText.text = news.text
        postViewsCount.text = news.viewsCount.toString()
        postSharesCount.text = news.sharesCount.toString()
        postLikesCount.text = news.likesCount.toString()
        postCommentsCount.text = news.commentsCount.toString()
        likedByPeople.text = news.likesCount.toString() + " people liked this"
        postImage.setImageResource(news.img)
        icon.setImageResource(news.iconImg)
    }
}
package com.example.vkkotlin

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


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
    private var news: News? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
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
        news = intent.getParcelableExtra("news")
        postName.text = news!!.name
        postDate.text = news!!.date
        postText.text = news!!.text
        postViewsCount.text = news!!.viewsCount.toString()
        postSharesCount.text = news!!.sharesCount.toString()
        postLikesCount.text = news!!.likesCount.toString()
        postCommentsCount.text = news!!.commentsCount.toString()
        likedByPeople.text = news!!.likesCount.toString() + " people liked this"
        postImage.setImageResource(news!!.img)
        icon.setImageResource(news!!.iconImg)



    }
}
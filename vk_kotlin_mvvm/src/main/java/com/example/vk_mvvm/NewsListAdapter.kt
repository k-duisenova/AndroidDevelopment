package com.example.vk_mvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class NewsListAdapter : BaseRecyclerViewAdapter<News>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_news, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val myHolder = holder as PostViewHolder
        getItem(position)?.let { myHolder.bindView(news = it) }
    }

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private var postName = itemView.findViewById<TextView>(R.id.author)
        private var postDate = itemView.findViewById<TextView>(R.id.date)
        private var postText = itemView.findViewById<TextView>(R.id.contentText)
        private var postCommentsCount = itemView.findViewById<TextView>(R.id.comment)
        private var postLikesCount = itemView.findViewById<TextView>(R.id.like)
        private var postRepostsCount = itemView.findViewById<TextView>(R.id.share)
        private var postViewsCount = itemView.findViewById<TextView>(R.id.view_text)
        private var postImage = itemView.findViewById<ImageView>(R.id.imageView3)

        init {
            itemView.setOnClickListener(this)
        }

        fun bindView(news: News) {
            postName.text = news.name
            postDate.text = news.date
            postText.text = news.text
            postViewsCount.text = news.viewsCount.toString()
            postRepostsCount.text = news.sharesCount.toString()
            postCommentsCount.text = news.commentsCount.toString()
            postImage.setImageResource(news.img)
            postLikesCount.text = news.likesCount.toString()
        }

        override fun onClick(v: View?) {
            if (v != null) {
                itemClickListener?.onItemClick(adapterPosition, v)
            }
        }
    }
}
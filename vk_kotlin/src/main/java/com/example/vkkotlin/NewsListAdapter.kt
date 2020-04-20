package com.example.vkkotlin

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class NewsListAdapter(
    private var newsList: List<News>,
    private var listener: ItemClickListener?,
    var c: Context
) : RecyclerView.Adapter<NewsListAdapter.NewsViewHolder?>() {


    interface ItemClickListener {
        fun itemClick(position: Int, item: News?)
    }

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, null, false)
        val params: RecyclerView.LayoutParams = RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        view.layoutParams = params
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]
        holder.postName.text = news.name
        holder.postDate.text = news.date
        holder.postText.text = news.text
        holder.postViewsCount.text = news.viewsCount.toString()
        holder.postRepostsCount.text = news.sharesCount.toString()
        holder.postCommentsCount.text = news.commentsCount.toString()
        holder.postImage.setImageResource(news.img)
        holder.postLikesCount.text = news.likesCount.toString()
        if (news.isClicked) {
            holder.like.setImageResource(R.drawable.red_heart)
            holder.postLikesCount.setTextColor(Color.parseColor("#3B6FA1"))
        } else {
            holder.like.setImageResource(R.drawable.heart)
            holder.postLikesCount.setTextColor(Color.parseColor("#A6A9B0"))
        }
        holder.itemView.setOnClickListener {
            if (listener != null) {
                listener!!.itemClick(position, news)
            }
        }

    }


    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class NewsViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val postName: TextView
        var postDate: TextView
        var postText: TextView
        var postCommentsCount: TextView
        var postLikesCount: TextView
        var postRepostsCount: TextView
        var postViewsCount: TextView
        var postImage: ImageView
        val like: ImageView

        init {
            postName = itemView.findViewById(R.id.author)
            postDate = itemView.findViewById(R.id.date)
            postText = itemView.findViewById(R.id.contentText)
            postCommentsCount = itemView.findViewById(R.id.comment)
            postLikesCount = itemView.findViewById(R.id.like)
            postRepostsCount = itemView.findViewById(R.id.share)
            postViewsCount = itemView.findViewById(R.id.view_text)
            postImage = itemView.findViewById(R.id.imageView3)
            like = itemView.findViewById(R.id.like_button)
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}
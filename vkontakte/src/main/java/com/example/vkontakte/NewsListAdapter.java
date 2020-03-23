package com.example.vkontakte;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder> {

    private List<News> newsList;
    private ItemClickListener listener;
    Context c;

    AddToFavListener favListener;
    RemoveNewsListener removeFromFavListener;
    RemoveFromHomeListener removeFromHomeListener;


    public interface AddToFavListener{
        void addNewsToFav(News news);
    }

    public interface RemoveNewsListener{
        void removeFromFavNews(News news);
    }

    public interface RemoveFromHomeListener{
        void removeFromHomeNews(News news);
    }

    interface ItemClickListener {
        void itemClick(int position, News item);
    }

    public NewsListAdapter(List<News> newsList,
                           @Nullable ItemClickListener listener,
                           Context c,
                           @Nullable RemoveNewsListener removeFromFavListener) {
        this.newsList = newsList;
        this.listener = listener;
        this.c = c;
        this.removeFromFavListener = removeFromFavListener;
    }


    public NewsListAdapter(List<News> newsList,
                           @Nullable ItemClickListener listener,
                           @Nullable AddToFavListener favListener,
                           Context c,
                           @Nullable RemoveFromHomeListener removeFromHomeListener) {
        this.newsList = newsList;
        this.listener = listener;
        this.favListener = favListener;
        this.c = c;
        this.removeFromHomeListener = removeFromHomeListener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, null, false);

        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        view.setLayoutParams(params);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsViewHolder holder, final int position) {
        final News news = newsList.get(position);

        holder.postName.setText(news.getName());
        holder.postDate.setText(news.getDate());
        holder.postText.setText(news.getText());

        holder.postViewsCount.setText(String.valueOf(news.getViewsCount()));
        holder.postRepostsCount.setText(String.valueOf(news.getRepostsCount()));


        holder.postCommentsCount.setText(String.valueOf(news.getCommentsCount()));

        holder.postImage.setImageResource(news.getImg());

        holder.postLikesCount.setText(String.valueOf(news.getLikesCount()));

        if(news.isClicked){
            holder.like.setImageResource(R.drawable.red_heart);
            holder.postLikesCount.setTextColor(Color.parseColor("#3B6FA1"));
        }else{
            holder.like.setImageResource(R.drawable.heart);
            holder.postLikesCount.setTextColor(Color.parseColor("#A6A9B0"));
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.itemClick(position, news);
                }
            }
        });

        holder.like.setOnClickListener(new View.OnClickListener() {

            //  boolean clicked = false;

            @Override
            public void onClick(View view) {

                if(!news.isClicked) {
                    if(favListener != null){
                        favListener.addNewsToFav(news);
                    }
                    holder.like.setImageResource(R.drawable.red_heart);
                    int s = Integer.parseInt(holder.postLikesCount.getText().toString()) + 1;
                    holder.postLikesCount.setText(String.valueOf(s));
                    holder.postLikesCount.setTextColor(Color.parseColor("#3B6FA1"));
                    news.isClicked = true;


                }else{
                    if(removeFromFavListener != null){
                        removeFromFavListener.removeFromFavNews(news);
                    }
                    if(removeFromHomeListener != null){
                        removeFromHomeListener.removeFromHomeNews(news);
                    }
                    holder.like.setImageResource(R.drawable.heart);
                    int s = Integer.parseInt(holder.postLikesCount.getText().toString()) - 1;
                    holder.postLikesCount.setText(String.valueOf(s));
                    holder.postLikesCount.setTextColor(Color.parseColor("#A6A9B0"));
                    news.isClicked = false;
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public int getItemViewType(int position) {
        return position;
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{


        final TextView postName;
        TextView postDate;
        TextView postText;
        TextView postCommentsCount;
        TextView postLikesCount;
        TextView postRepostsCount;
        TextView postViewsCount;
        ImageView postImage;

        final ImageView like;

        NewsViewHolder(@NonNull View itemView) {

            super(itemView);

            postName = itemView.findViewById(R.id.author);
            postDate = itemView.findViewById(R.id.date);
            postText = itemView.findViewById(R.id.contentText);
            postCommentsCount = itemView.findViewById(R.id.comment);
            postLikesCount = itemView.findViewById(R.id.like);
            postRepostsCount = itemView.findViewById(R.id.share);
            postViewsCount = itemView.findViewById(R.id.view_text);
            postImage = itemView.findViewById(R.id.imageView3);

            like = itemView.findViewById(R.id.like_button);

        }
    }


}
package com.example.vkontakte;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NewsDetailActivity extends AppCompatActivity {
    TextView postName;
    TextView postDate;
    TextView postText;
    TextView postCommentsCount;
    TextView postLikesCount;
    TextView postRepostsCount;
    TextView postViewsCount;
    TextView likedByPeople;
    ImageView postImage;
    ImageView icon;
    News news;
    ImageView like;
    boolean isLiked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);


        postName = findViewById(R.id.author);
        postDate = findViewById(R.id.date);
        postText = findViewById(R.id.contentText);
        postCommentsCount = findViewById(R.id.comment);
        postLikesCount = findViewById(R.id.like);
        postRepostsCount = findViewById(R.id.share);
        postViewsCount = findViewById(R.id.view_text);
        likedByPeople = findViewById(R.id.likedbypeople);
        postImage = findViewById(R.id.imageView3);
        icon = findViewById(R.id.imageView);
        like = findViewById(R.id.like_button);
        news = getIntent().getParcelableExtra("news");
        isLiked = news.isClicked;

        postName.setText(news.getName());
        postDate.setText(news.getDate());
        postText.setText(news.getText());
        postViewsCount.setText(String.valueOf(news.getViewsCount()));
        postRepostsCount.setText(String.valueOf(news.getRepostsCount()));
        postLikesCount.setText(String.valueOf(news.getLikesCount()));
        postCommentsCount.setText(String.valueOf(news.getCommentsCount()));
        likedByPeople.setText(news.getLikesCount() + " people liked this");

        postImage.setImageResource(news.getImg());
        icon.setImageResource(news.getIconImg());
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLiked){
                    isLiked = true;
                    like.setImageResource(R.drawable.red_heart);
                    news.setLikesCount(news.getLikesCount()+1);
                    news.isClicked = true;
                    postLikesCount.setText(String.valueOf(news.getLikesCount()));
                } else {
                    isLiked = false;
                    like.setImageResource(R.drawable.heart);
                    news.setLikesCount(news.getLikesCount()-1);
                    news.isClicked = false;
                    postLikesCount.setText(String.valueOf(news.getLikesCount()));
                }
            }
        });
        if (isLiked){
            like.setImageResource(R.drawable.red_heart);
        } else {
            like.setImageResource(R.drawable.heart);
        }
    }
}

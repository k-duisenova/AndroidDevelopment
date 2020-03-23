package com.example.vkontakte;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;

public class News implements Parcelable {
    private String name;
    private String date;
    private String text;
    @Nullable
    public boolean isClicked;
    private int iconImg;
    private int likesCount;
    private int commentsCount;
    private int repostsCount;
    private int viewsCount;
    private int img;

    public News(String name,
                String date,
                String text,
                int likesCount,
                int commentsCount,
                int repostsCount,
                int viewsCount,
                int img,
                int iconImg,
                boolean isClicked) {
        this.name = name;
        this.date = date;
        this.text = text;
        this.likesCount = likesCount;
        this.commentsCount = commentsCount;
        this.repostsCount = repostsCount;
        this.viewsCount = viewsCount;
        this.img = img;
        this.iconImg = iconImg;
        this.isClicked = isClicked;
    }

    public int getImg() { return img; }
    public void setImg(int img) { this.img = img; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDate() {return date; }
    public void setDate(String date) { this.date = date; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public int getLikesCount() { return likesCount; }
    public void setLikesCount(int likesCount) { this.likesCount = likesCount; }
    public int getCommentsCount() { return commentsCount; }
    public void setCommentsCount(int commentsCount) { this.commentsCount = commentsCount; }
    public int getRepostsCount() { return repostsCount; }
    public void setRepostsCount(int repostsCount) { this.repostsCount = repostsCount; }
    public int getViewsCount() { return viewsCount; }
    public void setViewsCount(int viewsCount) { this.viewsCount = viewsCount; }
    public void setIconImg(int iconImg){ this.iconImg = iconImg; }
    public int getIconImg() { return iconImg; }
    public void setIsClicked(boolean isClicked) { this.isClicked = isClicked; }
    public boolean isClicked() { return isClicked; }

    @Override
    public String toString() {
        return "News{" +
                "name = " + name + '\'' +
                ", date = " + date + '\'' +
                ", text = " + text + '\'' +
                ", likesCount = " + likesCount +
                ", commentsCount = " + commentsCount +
                ", repostsCount = " + repostsCount +
                ", viewsCount = " + viewsCount
                ;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.date);
        parcel.writeString(this.name);
        parcel.writeString(this.text);
        parcel.writeInt(this.commentsCount);
        parcel.writeInt(this.likesCount);
        parcel.writeInt(this.repostsCount);
        parcel.writeInt(this.viewsCount);
        parcel.writeInt(img);
        parcel.writeInt(iconImg);
    }

    protected News(Parcel in){
        this.date = in.readString();
        this.name = in.readString();
        this.text = in.readString();
        this.commentsCount = in.readInt();
        this.likesCount = in.readInt();
        this.repostsCount = in.readInt();
        this.viewsCount = in.readInt();
        this.img = in.readInt();
        this.iconImg = in.readInt();
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel parcel) { return new News(parcel); }

        public News[] newArray(int i) { return new News[i]; }
    };
}

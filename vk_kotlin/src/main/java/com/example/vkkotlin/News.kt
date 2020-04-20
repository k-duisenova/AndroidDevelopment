package com.example.vkkotlin

import android.os.Parcel
import android.os.Parcelable


open class News : Parcelable {
    var name: String?
    var date: String?
    var text: String?
    var isClicked = false
    var iconImg: Int
    var likesCount: Int
    var commentsCount: Int
    var sharesCount: Int
    var viewsCount: Int
    var img: Int

    constructor(
        name: String?,
        date: String?,
        text: String?,
        likesCount: Int,
        commentsCount: Int,
        sharesCount: Int,
        viewsCount: Int,
        img: Int,
        iconImg: Int,
        isClicked: Boolean
    ) {
        this.name = name
        this.date = date
        this.text = text
        this.likesCount = likesCount
        this.commentsCount = commentsCount
        this.sharesCount = sharesCount
        this.viewsCount = viewsCount
        this.img = img
        this.iconImg = iconImg
        this.isClicked = isClicked
    }

    override fun toString(): String {
        return "News{" +
                "name = " + name + '\'' +
                ", date = " + date + '\'' +
                ", text = " + text + '\'' +
                ", likesCount = " + likesCount +
                ", commentsCount = " + commentsCount +
                ", repostsCount = " + sharesCount +
                ", viewsCount = " + viewsCount
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(date)
        parcel.writeString(name)
        parcel.writeString(text)
        parcel.writeInt(commentsCount)
        parcel.writeInt(likesCount)
        parcel.writeInt(sharesCount)
        parcel.writeInt(viewsCount)
        parcel.writeInt(img)
        parcel.writeInt(iconImg)
    }

    protected constructor(`in`: Parcel) {
        date = `in`.readString()
        name = `in`.readString()
        text = `in`.readString()
        commentsCount = `in`.readInt()
        likesCount = `in`.readInt()
        sharesCount = `in`.readInt()
        viewsCount = `in`.readInt()
        img = `in`.readInt()
        iconImg = `in`.readInt()
    }


    companion object CREATOR : Parcelable.Creator<News?> {
        override fun createFromParcel(parcel: Parcel): News? {
            return News(parcel)
        }

        override fun newArray(size: Int): Array<News?> {
            return arrayOfNulls(size)
        }
    }
}
package com.example.vk_mvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class NewsViewModel(application: Application) : AndroidViewModel(application) {
    private val _liveData = MutableLiveData<State>()
    val liveData: LiveData<State>
        get() = _liveData

    private val newsList: ArrayList<News> = ArrayList(
        listOf(
            NewsContents.new1,
            NewsContents.new2, NewsContents.new3, NewsContents.new4,
            NewsContents.new5, NewsContents.new6, NewsContents.new7,
            NewsContents.new8, NewsContents.new9, NewsContents.new10
        )
    )

    fun loadNews() {
        _liveData.value =
            State.Result(
                newsList
            )
    }

    fun searchNews(newsId: Int) {
        newsList.forEach {
            if (newsId == it.id) {
                _liveData.value =
                    State.SearchResult(
                        it
                    )
                return
            }
        }
    }

    sealed class State {
        data class Result(val newsList: ArrayList<News>) : State()
        data class SearchResult(val news: News) : State()
    }
}


package com.example.vkontakte;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavouritesFragment extends Fragment {

    private RecyclerView recyclerView;
    private NewsListAdapter adapter;

    private NewsListAdapter.ItemClickListener listener = null;
    private NewsListAdapter.RemoveNewsListener removeListener = null;

    private ArrayList<News> favouriteNews = new ArrayList<>();


    FavouritesFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.favourites_fragment, container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        listener = new NewsListAdapter.ItemClickListener() {
            @Override
            public void itemClick(int position, News item) {
                Intent intent = new Intent(getContext(), NewsDetailActivity.class);
                intent.putExtra("news", item);
                startActivity(intent);

            }
        };

        recyclerView = view.findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new NewsListAdapter(favouriteNews, listener, getContext(), removeListener);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(null);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof NewsListAdapter.RemoveNewsListener){
            removeListener = (NewsListAdapter.RemoveNewsListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        removeListener = null;
    }

    public void addNews(News news){
        favouriteNews.add(news);
        int index = favouriteNews.indexOf(news);
        int likes = news.getLikesCount() + 1;
        news.setLikesCount(likes);
        adapter.notifyItemInserted(index);
    }

    public void removeNews(News news){
        int index = favouriteNews.indexOf(news);
        favouriteNews.remove(news);
        adapter.notifyItemRemoved(index);
    }

    public void findRemoveNews(News news){
        if( favouriteNews.contains(news)) {
            removeNews(news);
        }
    }



}

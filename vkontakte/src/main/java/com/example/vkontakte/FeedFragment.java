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

public class FeedFragment extends Fragment {


    FeedFragment(){}

    private RecyclerView recyclerView;
    private NewsListAdapter adapter;

    private NewsListAdapter.ItemClickListener listener = null;
    private NewsListAdapter.AddToFavListener favListener = null;
    private NewsListAdapter.RemoveFromHomeListener removeFromHomeListener = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.feed_fragment, container,false);
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

        NewsContents.create();
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new NewsListAdapter(NewsContents.getNews(), listener, favListener, getContext(), removeFromHomeListener);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof NewsListAdapter.AddToFavListener){
            favListener = (NewsListAdapter.AddToFavListener) context;
        }
        if(context instanceof NewsListAdapter.RemoveFromHomeListener){
            removeFromHomeListener = (NewsListAdapter.RemoveFromHomeListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        favListener = null;
        removeFromHomeListener = null;
    }

    public void updateLikes(News news){
        NewsContents.findChangeNews(news);
        adapter.notifyDataSetChanged();
    }
}

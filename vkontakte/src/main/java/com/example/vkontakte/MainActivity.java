package com.example.vkontakte;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements NewsListAdapter.AddToFavListener, NewsListAdapter.RemoveNewsListener, NewsListAdapter.RemoveFromHomeListener {

    final Fragment feedFragment = new FeedFragment();
    final Fragment favouritesFragment = new FavouritesFragment();
    final FragmentManager fragmentManager = getSupportFragmentManager();
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentList = new ArrayList<>();
        fragmentList.add(feedFragment);
        fragmentList.add(favouritesFragment);

        viewPager = findViewById(R.id.pager);
        pagerAdapter = new PagerAdapter(fragmentManager, fragmentList);
        viewPager.setAdapter(pagerAdapter);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }



    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.home:
                            viewPager.setCurrentItem(0, false);
                            return true;

                        case R.id.favourites:
                            viewPager.setCurrentItem(1, false);
                            return true;
                    }
                    return false;
                }
            };

    @Override
    public void addNewsToFav(News news) {
        Toast toast = Toast.makeText(this, "Added to Favourites",Toast.LENGTH_SHORT);
        toast.show();

        Fragment fragment = fragmentList.get(1);
        ((FavouritesFragment)fragment).addNews(news);

    }

    @Override
    public void removeFromFavNews(News news) {
        Fragment fragment = fragmentList.get(1);
        ((FavouritesFragment)fragment).removeNews(news);
        fragment = fragmentList.get(0);
        ((FeedFragment)fragment).updateLikes(news);
    }

    @Override
    public void removeFromHomeNews(News news) {

        Toast toast = Toast.makeText(this, "Removed from Favourites", Toast.LENGTH_SHORT);
        toast.show();

        Fragment fragment = fragmentList.get(1);
        ((FavouritesFragment)fragment).findRemoveNews(news);
    }
}
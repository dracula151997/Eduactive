package com.project.semicolon.eduactive.ui.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.semicolon.eduactive.R;

import java.util.ArrayList;
import java.util.List;

import adapters.News;
import adapters.NewsAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    private NewsAdapter adapter;


    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        RecyclerView recycler = view.findViewById(R.id.news_recycler);

        adapter = new NewsAdapter();
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        List<News> newsList = new ArrayList<>();
        newsList.add(new News(R.drawable.ic_launcher_background, "Title 1", "Category 1", "Wed 15 2019"));
        newsList.add(new News(R.drawable.ic_launcher_background, "Title 2", "Category 2", "Wed 15 2019"));
        newsList.add(new News(R.drawable.ic_launcher_background, "Title 3", "Category 3", "Wed 15 2019"));
        newsList.add(new News(R.drawable.ic_launcher_background, "Title 4", "Category 4", "Wed 15 2019"));
        newsList.add(new News(R.drawable.ic_launcher_background, "Title 5", "Category 5", "Wed 15 2019"));
        newsList.add(new News(R.drawable.ic_launcher_background, "Title 6", "Category 6", "Wed 15 2019"));
        newsList.add(new News(R.drawable.ic_launcher_background, "Title 7", "Category 7", "Wed 15 2019"));

        adapter.setNewsList(newsList);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}

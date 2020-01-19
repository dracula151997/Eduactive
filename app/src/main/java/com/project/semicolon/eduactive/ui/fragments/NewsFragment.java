package com.project.semicolon.eduactive.ui.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.semicolon.eduactive.R;
import com.project.semicolon.eduactive.adapters.GenericRecyclerAdapter;
import com.project.semicolon.eduactive.database.DatabaseClient;
import com.project.semicolon.eduactive.database.entities.NewsEntity;
import com.project.semicolon.eduactive.listeners.OnListItemClickListener;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment implements OnListItemClickListener {
    private static final String TAG = "NewsFragment";
    private GenericRecyclerAdapter<NewsEntity> adapter;
    private DatabaseClient db;

    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = DatabaseClient.getInstance(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        RecyclerView recycler = view.findViewById(R.id.news_recycler);

        adapter = new GenericRecyclerAdapter<>(R.layout.list_item_articles);
        adapter.setOnListItemClickListener(this);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        fetchArticlesFromDatabase();
        return view;
    }

    private void fetchArticlesFromDatabase() {
        db.getNewsDao().getAllArticles().observe(this, new Observer<List<NewsEntity>>() {
            @Override
            public void onChanged(List<NewsEntity> newsEntities) {
                adapter.setItems(newsEntities);
            }
        });
    }

    @Override
    public void onItemClicked(View view, int position) {
        Log.d(TAG, "onItemClicked: " + position);
    }
}

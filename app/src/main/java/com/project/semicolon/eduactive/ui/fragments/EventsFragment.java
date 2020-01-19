package com.project.semicolon.eduactive.ui.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.project.semicolon.eduactive.R;
import com.project.semicolon.eduactive.adapters.GenericRecyclerAdapter;
import com.project.semicolon.eduactive.database.DatabaseClient;
import com.project.semicolon.eduactive.database.entities.EventEntity;
import com.project.semicolon.eduactive.databinding.EventsFragmentBind;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {
    private EventsFragmentBind binding;
    private DatabaseClient databaseClient;


    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = EventsFragmentBind.inflate(inflater, container, false);
        final GenericRecyclerAdapter<EventEntity> eventsAdapter = new GenericRecyclerAdapter<>(R.layout.list_item_events);
        binding.eventsRecycler.setAdapter(eventsAdapter);
        databaseClient.eventDao().getAllEvents().observe(this, new Observer<List<EventEntity>>() {
            @Override
            public void onChanged(List<EventEntity> eventEntities) {
                if (eventEntities.size() == 0) {
                    //empty state
                }

                eventsAdapter.setItems(eventEntities);
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseClient = DatabaseClient.getInstance(getContext());
    }
}

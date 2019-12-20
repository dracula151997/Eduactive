package com.project.semicolon.eduactive.ui.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.semicolon.eduactive.R;
import com.project.semicolon.eduactive.adapters.StudyTimeTableAdapter;
import com.project.semicolon.eduactive.adapters.StudyTimeTableModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudyTimeTableFragment extends Fragment {
    private StudyTimeTableAdapter adapter;


    public StudyTimeTableFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_study_time_table, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        RecyclerView studyTimeTableRecycler = view.findViewById(R.id.study_time_table_recycler);
        studyTimeTableRecycler.setHasFixedSize(true);
        studyTimeTableRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new StudyTimeTableAdapter();
        studyTimeTableRecycler.setAdapter(adapter);

        setDummyData();




    }

    private void setDummyData() {
         List<StudyTimeTableModel> modelList = new ArrayList<>();

        modelList.add(new StudyTimeTableModel("Course 1", "Instructor 1", "8.30 AM - 10 AM", "H214"));
        modelList.add(new StudyTimeTableModel("Course 2", "Instructor 2", "10.10 AM - 11.40 AM", "H313"));
        modelList.add(new StudyTimeTableModel("Course 3", "Instructor 3", "11.50 AM - 1.20 PM", "H214"));
        modelList.add(new StudyTimeTableModel("Course 4", "Instructor 4", "1.40 PM - 3.10 PM", "H507"));

        adapter.setModelList(modelList);

    }
}

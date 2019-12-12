package com.project.semicolon.eduactive.ui.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.semicolon.eduactive.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudyTimeTableFragment extends Fragment {


    public StudyTimeTableFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_study_time_table, container, false);
    }

}

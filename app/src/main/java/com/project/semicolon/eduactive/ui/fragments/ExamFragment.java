package com.project.semicolon.eduactive.ui.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.semicolon.eduactive.ExamAdapter;
import com.project.semicolon.eduactive.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExamFragment extends Fragment {


    public ExamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_exam, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ExamAdapter adapter = new ExamAdapter();


        super.onViewCreated(view, savedInstanceState);
    }
}

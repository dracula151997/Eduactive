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
        RecyclerView examsRecycler = view.findViewById(R.id.Examrecycler);
        examsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        examsRecycler.setAdapter(adapter);
        examsRecycler.setHasFixedSize(true);


        super.onViewCreated(view, savedInstanceState);
    }
}

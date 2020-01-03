package com.project.semicolon.eduactive.ui.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.project.semicolon.eduactive.adapters.ExamsBankAdapter;
import com.project.semicolon.eduactive.database.DatabaseClient;
import com.project.semicolon.eduactive.database.entities.ExamsBankEntity;
import com.project.semicolon.eduactive.databinding.ExamBankFragmentBinding;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExamsBankFragment extends Fragment {
    private ExamBankFragmentBinding binding;
    private ExamsBankAdapter adapter;
    private DatabaseClient db;


    public ExamsBankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = ExamBankFragmentBinding.inflate(inflater, container, false);
        adapter = new ExamsBankAdapter();
        db = DatabaseClient.getInstance(getContext());
        setupRecyclerView();
        fetchExamsFromDatabase();

        return binding.getRoot();
    }

    private void fetchExamsFromDatabase() {
        db.getExamsDao().getAllExams().observe(this, new Observer<List<ExamsBankEntity>>() {
            @Override
            public void onChanged(List<ExamsBankEntity> examsBankEntities) {
                if (examsBankEntities.size() == 0) {
                    //empty
                    return;
                }

                adapter.setExams(examsBankEntities);
            }
        });

    }

    private void setupRecyclerView() {
        binding.recyclerExams.setHasFixedSize(true);
        binding.recyclerExams.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerExams.setAdapter(adapter);
    }

}

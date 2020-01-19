package com.project.semicolon.eduactive.ui.fragments;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.project.semicolon.eduactive.R;
import com.project.semicolon.eduactive.adapters.GenericRecyclerAdapter;
import com.project.semicolon.eduactive.database.DatabaseClient;
import com.project.semicolon.eduactive.database.entities.ExamsBankEntity;
import com.project.semicolon.eduactive.databinding.ExamBankFragmentBinding;
import com.project.semicolon.eduactive.listeners.OnListItemClickListener;
import com.project.semicolon.eduactive.utils.AppHelper;
import com.project.semicolon.eduactive.utils.PermissionHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExamsBankFragment extends Fragment implements OnListItemClickListener {
    private static final String TAG = "ExamsBankFragment";
    private static final int REQUEST_CODE_STORAGE = 10;
    private ExamBankFragmentBinding binding;
    private DatabaseClient db;
    private GenericRecyclerAdapter<ExamsBankEntity> adapter;
    private List<ExamsBankEntity> examsList;
    private PermissionHelper permissionHelper;
    private ExamsBankEntity exam;


    public ExamsBankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = ExamBankFragmentBinding.inflate(inflater, container, false);
        db = DatabaseClient.getInstance(getContext());
        examsList = new ArrayList<>();
        adapter = new GenericRecyclerAdapter<>(R.layout.list_item_exams_bank);
        permissionHelper = new PermissionHelper(getContext());
        setupRecyclerView();
        fetchExamsFromDatabase();

        return binding.getRoot();
    }

    private void fetchExamsFromDatabase() {
        db.getExamsDao().getAllExams().observe(this, new Observer<List<ExamsBankEntity>>() {
            @Override
            public void onChanged(List<ExamsBankEntity> examsBankEntities) {
                examsList.addAll(examsBankEntities);
                if (examsBankEntities.size() == 0) {
                    //empty
                    return;
                }

                adapter.setItems(examsBankEntities);
            }
        });

    }

    private void setupRecyclerView() {
        binding.recyclerExams.setHasFixedSize(true);
        binding.recyclerExams.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerExams.setAdapter(adapter);
        adapter.setOnListItemClickListener(this);
    }


    @Override
    public void onItemClicked(View view, int position) {
        if (view.getId() == R.id.btn_download_pdf) {
            exam = examsList.get(position);
            if (permissionHelper.checkDevice()) {
                if (permissionHelper.isPermissionGranted(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    AppHelper.downloadFileFromHttp(Objects.requireNonNull(getContext()), exam.getPdf());
                } else {
                    permissionHelper.requestPermission(getActivity(),
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            REQUEST_CODE_STORAGE);
                }

            }

        } else {
            Toast.makeText(getContext(), "" + position, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE_STORAGE &&
                grantResults.length > 0 &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            AppHelper.downloadFileFromHttp(getContext(), exam.getPdf());

        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}

package com.project.semicolon.eduactive.ui.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.project.semicolon.eduactive.R;
import com.project.semicolon.eduactive.database.DatabaseClient;
import com.project.semicolon.eduactive.database.entities.StudentEntity;
import com.project.semicolon.eduactive.databinding.LoginFragmentBinding;
import com.project.semicolon.eduactive.utils.AppExactors;
import com.project.semicolon.eduactive.utils.AppHelper;

import io.rmiri.buttonloading.ButtonLoading;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements ButtonLoading.OnButtonLoadingListener {
    private LoginFragmentBinding loginBinding;
    private DatabaseClient db;
    private static final String TAG = "LoginFragment";


    public LoginFragment() {
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
        loginBinding = LoginFragmentBinding.inflate(inflater, container, false);

        return loginBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loginBinding.btnSignIn.setOnButtonLoadingListener(this);
    }

    private void signInProcess() {
        final String username = loginBinding.etUsername.getText().toString();
        final String password = loginBinding.etPass.getText().toString();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                login(username, password);

            }
        }, 10000);


    }

    private void login(final String username, final String password) {
        AppExactors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                loginBinding.btnSignIn.setProgress(true);
                StudentEntity studentEntity = db.getStudentDao().studentLogin(username, password);
                if (studentEntity != null) {
                    //navigate to Main fragment.
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            AppHelper.navigate(getActivity(), R.id.nav_host_fragment, R.id.newsFragment);
                            loginBinding.btnSignIn.setProgress(false);

                        }
                    });

                } else {
                    loginBinding.btnSignIn.setProgress(false);
                }
            }
        });
    }

    @Override
    public void onClick() {
        signInProcess();


    }

    @Override
    public void onFinish() {
        Toast.makeText(getContext(), "onFinish", Toast.LENGTH_SHORT).show();

    }
}

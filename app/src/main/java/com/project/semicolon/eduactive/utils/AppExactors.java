package com.project.semicolon.eduactive.utils;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExactors {
    private static AppExactors instance;
    private final Executor diskIO;
    private final Executor mainThread;

    public AppExactors(Executor diskIO, Executor mainThread) {
        this.diskIO = diskIO;
        this.mainThread = mainThread;
    }

    public static AppExactors getInstance() {
        if (instance == null) {
            instance = new AppExactors(Executors.newSingleThreadExecutor(), new MainThreadExector());
        }
        return instance;
    }

    public Executor diskIO() {
        return diskIO;
    }

    public Executor mainThread() {
        return mainThread;
    }

    private static class MainThreadExector implements Executor {
        private Handler handler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(Runnable runnable) {
            handler.post(runnable);

        }
    }
}

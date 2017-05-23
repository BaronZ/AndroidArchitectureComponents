package com.zzb.androidarchitecturecomponents.handlelifecycle;

import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;

import com.zzb.androidarchitecturecomponents.R;

public class HandleLifeCycleActivity extends LifecycleActivity {

    private TaskA mTaskA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle_life_cycle);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LongRunTask.run(new Runnable() {
            @Override
            public void run() {
                //activity may on resume
                mTaskA.onPause();
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        LongRunTask.run(new Runnable() {
            @Override
            public void run() {
                //activity may on pause
                mTaskA.onResume();
            }
        });
    }
}

package com.zzb.androidarchitecturecomponents.handlelifecycle_solution;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;

/**
 * Created by ZZB on 2017/5/22.
 */

public class TaskA implements LifecycleObserver {
    private boolean mEnabled;
    private Lifecycle mLifecycle;

    public TaskA(Lifecycle lifecycle) {
        mLifecycle = lifecycle;
    }

    public void onResume() {
        if (mEnabled) {
            doOnResume();
        }
    }

    public void onPause() {
        if (!mEnabled) {
            doOnPause();
        }
    }

    private void doOnPause() {

    }

    private void doOnResume() {

    }

    public void enable() {
        mEnabled = true;
        if (mLifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            doOnResume();
        }
    }

    public void disable() {
        mEnabled = false;
    }
}

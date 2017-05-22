package com.zzb.androidarchitecturecomponents.sharebetweenfragments;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.zzb.androidarchitecturecomponents.approach1.Score;

/**
 * Created by ZZB on 2017/5/22.
 */

public class SharedViewModel extends ViewModel {
    private static final String TAG = "SharedViewModel";
    private MutableLiveData<Score> mScoreMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<Score> getScoreLiveData() {
        return mScoreMutableLiveData;
    }

    public void updateScore() {
        Log.d(TAG, "updateScore");
        Score score = mScoreMutableLiveData.getValue();
        if (score == null) {
            score = new Score();
        }
        ++score.data;
        mScoreMutableLiveData.setValue(score);
    }
}

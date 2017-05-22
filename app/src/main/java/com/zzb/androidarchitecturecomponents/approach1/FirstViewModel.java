package com.zzb.androidarchitecturecomponents.approach1;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by ZZB on 2017/5/22.
 */

public class FirstViewModel extends ViewModel {


    private MutableLiveData<Score> mScoreLiveData = new MutableLiveData<>();


    public MutableLiveData<Score> getScoreLiveData() {
        return mScoreLiveData;
    }
}

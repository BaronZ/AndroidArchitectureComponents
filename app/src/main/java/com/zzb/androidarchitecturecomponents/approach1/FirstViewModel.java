package com.zzb.androidarchitecturecomponents.approach1;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

/**
 * Since these objects might be destroyed or re-created by the operating system, any data you hold in them will be lost.
 * For instance, if you have a list of users in your activity, when the activity is re-created for a configuration change,
 * the new activity will have to re-fetch the list of users. For simple data, the activity can use the onSaveInstanceState() method and restore its data from the bundle in onCreate(),
 * but this approach is only suitable for small information like UI state, not for potentially large amounts of data like a list of users.
 * <p>
 * Another problem is that, these UI Controllers (activities, fragments, and so on) frequently need to make some asynchronous calls which may take some time to return.
 * The UI Controller needs to manage these calls and clean them up when it is destroyed to avoid potential memory leaks.
 * This requires a lot of maintenance, and in the case where the object is recreated for a configuration change,
 * it is a waste of resources since it will need to re-issue the same call.
 * <p>
 * Last but not least, these UI Controllers already have a lot of responsibility to react to user actions or handle the operating system communication.
 * When they also need to handle their resources manually, it bloats the class, creating "god activities" (or "god fragments"); that is,
 * a single class that tries to handle all of an app's work all by itself, instead of delegating work to other classes. This also makes testing a lot harder.
 * <p>
 * It would be easier and more efficient to separate out view data ownership from UI controller logic.
 * Lifecycles provides a new class called ViewModel, which is a helper class for the UI Controller that is responsible to prepare the data for the UI.
 * The ViewModel is automatically retained during configuration changes so the data it holds is immediately available to the next activity or fragment instance.
 * For the example we’ve mentioned above, it would be the ViewModel’s responsibility to acquire and keep the list of users, not the activity or the fragment.
 * <p>
 * ViewModel的生命周期：与其绑定的LifeCycle一致（Activity finish 或者Fragment detached）
 * The lifecycle of a ViewModel
 * ViewModel objects are scoped to the Lifecycle passed to the ViewModelProvider when getting the ViewModel.
 * The ViewModel stays in memory until the Lifecycle it’s scoped to goes away permanently—in the case of an activity, once it finishes; in the case of a fragment, once it’s detached.
 * Created by ZZB on 2017/5/22.
 */

public class FirstViewModel extends ViewModel {

    private static final String TAG = "FirstViewModel";
    private MutableLiveData<Score> mScoreLiveData = new MutableLiveData<>();


    public MutableLiveData<Score> getScoreLiveData() {
        return mScoreLiveData;
    }

    public void updateScore() {
        Log.d(TAG, "updateScore");
        Score score = mScoreLiveData.getValue();
        if (score == null) {
            score = new Score();
        }
        ++score.data;
        mScoreLiveData.setValue(score);
    }

    /**
     * When the owner activity is finished, the Framework calls ViewModel’s onCleared() method so that it can clean up resources.
     */
    @Override
    protected void onCleared() {
        Log.d(TAG, "onCleared");
        super.onCleared();
    }
}

package com.zzb.androidarchitecturecomponents.sharebetweenfragments;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zzb.androidarchitecturecomponents.R;
import com.zzb.androidarchitecturecomponents.approach1.Score;

/**

 */
public class FragmentB extends LifecycleFragment {


    public FragmentB() {
        // Required empty public constructor
    }


    public static FragmentB newInstance() {
        FragmentB fragment = new FragmentB();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_b, container, false);

        final TextView tv = (TextView) contentView.findViewById(R.id.tv_content);
        SharedViewModel sharedViewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        sharedViewModel.getScoreLiveData().observe(this, new Observer<Score>() {
            @Override
            public void onChanged(@Nullable Score score) {
                tv.setText("observe data changed from other fragment:" + score.data);
            }
        });
        return contentView;
    }

}

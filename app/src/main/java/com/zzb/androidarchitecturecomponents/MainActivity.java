package com.zzb.androidarchitecturecomponents;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zzb.androidarchitecturecomponents.approach1.FirstViewModel;
import com.zzb.androidarchitecturecomponents.approach1.Score;
import com.zzb.androidarchitecturecomponents.sharebetweenfragments.ShareViewModelActivity;

public class MainActivity extends LifecycleActivity {
    private TextView mTvScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvScore = (TextView) findViewById(R.id.tv_score);

        final FirstViewModel viewModel = ViewModelProviders.of(this).get(FirstViewModel.class);
        final Score score = new Score();
        displayScore(score);

        View btnAddScore = findViewById(R.id.btn_add_score);
        btnAddScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.updateScore();
            }
        });

        viewModel.getScoreLiveData().observe(this, new Observer<Score>() {
            @Override
            public void onChanged(@Nullable Score score) {
                displayScore(score);
            }
        });
    }


    private void displayScore(Score score) {
        mTvScore.setText(String.valueOf(score.data));
    }

    public void onClick(View view) {
        ShareViewModelActivity.launch(this);
    }
}

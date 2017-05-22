package com.zzb.androidarchitecturecomponents.sharebetweenfragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zzb.androidarchitecturecomponents.R;

public class ShareViewModelActivity extends AppCompatActivity {

    public static final void launch(Context context) {
        Intent intent = new Intent(context, ShareViewModelActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_view_model);
    }
}

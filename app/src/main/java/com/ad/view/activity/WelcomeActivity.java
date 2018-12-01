package com.ad.view.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;

import com.ad.R;
import com.ad.app.ActivityManager;
import com.ad.view.base.BaseActivity;

public class WelcomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }


    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public void loadData() {

    }

    @Override
    public int getContentId() {
        return 0;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

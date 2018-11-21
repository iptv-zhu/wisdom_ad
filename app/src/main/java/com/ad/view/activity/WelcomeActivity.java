package com.ad.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ad.R;
import com.ad.utils.Util;
import com.ad.utils.Utils;
import com.ad.view.base.BaseActivity;

public class WelcomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Util utils = new Util();
        String speed = utils.getNetSpeed(this);
        System.out.println("@@@@@" + Utils.getMACAddress());
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

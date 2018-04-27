package com.cmy.base_project.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cmy.base_project.R;
import com.cmy.base_project.app.BaseApplication;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BaseApplication.getInstance().destory();
    }
}

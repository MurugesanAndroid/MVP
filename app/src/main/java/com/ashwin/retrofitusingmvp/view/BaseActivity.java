package com.ashwin.retrofitusingmvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashwin.retrofitusingmvp.R;

public class BaseActivity extends AppCompatActivity {

    protected AppCompatActivity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        mActivity = this;
    }
}

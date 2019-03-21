package com.hello.resume.myresumedemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;

public class PersonalSpaceActivity extends BaseActivity {

    private CollapsingToolbarLayout mColbarLayout ;
    private Toolbar mToolBar ;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_space);
        mToolBar = findViewById(R.id.toolBar);
        setSupportActionBar(mToolBar);
        mColbarLayout = findViewById(R.id.colbar_layout);
        mColbarLayout.setTitle("  ");
    }

}

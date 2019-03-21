package com.hello.resume.myresumedemo;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.hello.resume.myresumedemo.adapter.FragmentAdapter;
import com.hello.resume.myresumedemo.util.ActivityStartUtil;
import com.hello.resume.myresumedemo.util.ToastUtils;
import com.hello.resume.myresumedemo.view.TouchLatourView;

import java.lang.reflect.Method;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.touch_view)
    TouchLatourView touchView;

    private Toolbar mToolBar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private DrawerLayout mDrawerLayout;

    private NavigationView mNavigation;
    private FloatingActionButton mFaButton;

    ArrayList<String> mTabList;
    ArrayList<Fragment> mFragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mToolBar = findViewById(R.id.toolBar);
        mNavigation = findViewById(R.id.nv_main);
        mNavigation.setItemIconTintList(null);
        mDrawerLayout = findViewById(R.id.drawerLayout);
        mFaButton = findViewById(R.id.fa_button);
        setSupportActionBar(mToolBar);

        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        mToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                ToastUtils.getInstance().showMessage(MainActivity.this, item.getTitle().toString());
                return true;
            }
        });

        mTabLayout = findViewById(R.id.tabLayout);

        mTabList = new ArrayList<>();
        mFragments = new ArrayList<>();
        mTabList.add("自定义控件");
        mTabList.add("足迹");
        mTabList.add("体育");
        mTabList.add("兴趣");
        mTabList.add("闲暇");
        mTabList.add("作息");
        mTabList.add("方向");
        mTabList.add("开源");
        mTabList.add("节流");

        for (int i = 0; i < mTabList.size(); i++) {
            String item = mTabList.get(i);
            mTabLayout.addTab(mTabLayout.newTab().setText(item));

            if (i == 0) {
//                mFragments.add()
            }

            mFragments.add(new MyListFragment(item));
        }

        FragmentAdapter mAdapter = new FragmentAdapter(getSupportFragmentManager(), mFragments, mTabList);
        mViewPager = findViewById(R.id.viewPager);
        mViewPager.setAdapter(mAdapter);

        mTabLayout.setupWithViewPager(mViewPager);

        mNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();

                switch (item.getItemId()) {
                    case R.id.menu_personal_space:
                        ActivityStartUtil.startActivity(MainActivity.this, PersonalSpaceActivity.class);
                        return true;
                }
                return true;
            }
        });

        mFaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                touchView.smoothScrollTo(-300 , 0);
                ObjectAnimator.ofFloat(touchView,"translationX",0,300).setDuration(2000).start();
                Snackbar.make(view, "放首歌曲", Snackbar.LENGTH_SHORT).show();
            }
        });

    }


    @SuppressLint("RestrictedApi")
    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        if (menu != null) {
            if (menu.getClass() == MenuBuilder.class) {
                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return super.onPrepareOptionsPanel(view, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}

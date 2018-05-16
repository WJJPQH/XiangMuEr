package com.example.com.jingdong_demo;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.com.jingdong_demo.classfix.ClassApiFragment;
import com.example.com.jingdong_demo.home.HomeFragment;

public class MainActivity extends AppCompatActivity {
    private FrameLayout mFl;
    private RadioGroup group;
    private FragmentManager fragmentManager;
    private HomeFragment homePageFragment;
    private ClassApiFragment classApiFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();
        homePageFragment = new HomeFragment();
        classApiFragment = new ClassApiFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.f1, homePageFragment).commit();

    }
    private void setListener() {
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rgHome:
                        //首页
                        fragmentManager.beginTransaction().replace(R.id.f1,homePageFragment).commit();
                        break;
                    case R.id.rgclass:
                        fragmentManager.beginTransaction().replace(R.id.f1,classApiFragment).commit();
                        break;
                    case R.id.rgFind:

                        break;
                    case R.id.rgShop:

                        break;
                    case R.id.rgMy:

                        break;
                }
            }
        });
    }


    private void initView() {
        mFl = (FrameLayout) findViewById(R.id.f1);
        group = findViewById(R.id.rg);
    }
}

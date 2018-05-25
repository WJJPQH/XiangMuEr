package com.example.com.jingdong_demo;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.com.jingdong_demo.base.BaseActivity;
import com.example.com.jingdong_demo.classfix.ClassApiFragment;
import com.example.com.jingdong_demo.home.HomeFragment;
import com.example.com.jingdong_demo.shop.ShopFragment;
import com.example.com.jingdong_demo.wode.WoDeFragment;

public class MainActivity extends AppCompatActivity {
    private FrameLayout mFl;
    private RadioGroup group;
    private int currentIndex = 1;
    private FragmentManager fragmentManager;
    private HomeFragment homePageFragment;
    private ClassApiFragment classApiFragment;
    private WoDeFragment woDeFragment;
    private ShopFragment shopFragment;
    private RadioButton rgHome;
    private RadioButton rgclass;
    private RadioButton rgFind;
    private RadioButton rgShop;
    private RadioButton rgMy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        homePageFragment = new HomeFragment();
        classApiFragment = new ClassApiFragment();
        woDeFragment = new WoDeFragment();
        shopFragment = new ShopFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.f1, homePageFragment).commit();
        setListener();

    }
    private void setListener() {
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rgHome:
                        //首页
                        if (currentIndex == 1) {
                            return;
                        }
                        currentIndex = 1;
                        fragmentManager.beginTransaction().replace(R.id.f1,homePageFragment).commit();
                        break;
                    case R.id.rgclass:
                        if (currentIndex == 2) {
                            return;
                        }
                        currentIndex = 2;
                        fragmentManager.beginTransaction().replace(R.id.f1,classApiFragment).commit();
                        break;
                    case R.id.rgFind:
                        if (currentIndex == 3) {
                            return;
                        }
                        currentIndex = 3;
                        break;
                    case R.id.rgShop:
                        if (currentIndex == 4) {
                            return;
                        }
                        currentIndex = 4;
                        fragmentManager.beginTransaction().replace(R.id.f1,shopFragment).commit();
                        break;
                    case R.id.rgMy:
                        if (currentIndex == 5) {
                            return;
                        }
                        currentIndex = 5;
                        fragmentManager.beginTransaction().replace(R.id.f1,woDeFragment).commit();
                        break;
                }
            }
        });
    }


    private void initView() {
        mFl = (FrameLayout) findViewById(R.id.f1);
        group = findViewById(R.id.rg);
        rgHome = findViewById(R.id.rgHome);
        rgclass = findViewById(R.id.rgclass);
        rgFind = findViewById(R.id.rgFind);
        rgMy = findViewById(R.id.rgMy);
        rgShop = findViewById(R.id.rgShop);
    }

}

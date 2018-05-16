package com.example.com.jingdong_demo.component;

import com.example.com.jingdong_demo.classfix.ClassApiFragment;
import com.example.com.jingdong_demo.classfix.InActivity;
import com.example.com.jingdong_demo.classfix.XiangQingActivity;
import com.example.com.jingdong_demo.home.HomeFragment;
import com.example.com.jingdong_demo.login.LoginActivity;
import com.example.com.jingdong_demo.module.HttpModule;

import dagger.Component;

@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(LoginActivity loginActivity);

    void inject(HomeFragment homeFragment);

    void inject(ClassApiFragment classApiFragment);

    void inject(InActivity inActivity);

    void inject(XiangQingActivity xiangQingActivity);
}

package com.example.com.jingdong_demo.component;

import com.example.com.jingdong_demo.classfix.ClassApiFragment;
import com.example.com.jingdong_demo.classfix.InActivity;
import com.example.com.jingdong_demo.classfix.XiangQingActivity;
import com.example.com.jingdong_demo.home.HomeFragment;
import com.example.com.jingdong_demo.login.LoginActivity;
import com.example.com.jingdong_demo.mine.MakeSureOrderActivity;
import com.example.com.jingdong_demo.mine.fragment.FragmentAllOrder;
import com.example.com.jingdong_demo.mine.fragment.FragmentWaitOrder;
import com.example.com.jingdong_demo.module.HttpModule;
import com.example.com.jingdong_demo.shop.ShopActivity;
import com.example.com.jingdong_demo.shop.ShopFragment;
import com.example.com.jingdong_demo.wode.Main2Activity;

import dagger.Component;

@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(LoginActivity loginActivity);

    void inject(HomeFragment homeFragment);

    void inject(ClassApiFragment classApiFragment);

    void inject(InActivity inActivity);

    void inject(XiangQingActivity xiangQingActivity);

    void inject(ShopActivity shopActivity);

    void inject(MakeSureOrderActivity makeSureOrderActivity);

    void inject(ShopFragment shopFragment);

    void inject(Main2Activity main2Activity);

    void inject(FragmentAllOrder fragmentAllOrder);

    void inject(FragmentWaitOrder fragmentWaitOrder);
}

package com.example.com.jingdong_demo.home;

import com.example.com.jingdong_demo.base.BaseContract;
import com.example.com.jingdong_demo.bean.AdBean;
import com.example.com.jingdong_demo.bean.CatagoryBean;

public interface HomePageContract {
    interface View extends BaseContract.BaseView{
        void getAdSuccess(AdBean adBean);
        void getCatagorySuccess(CatagoryBean catagoryBean);
    }
    interface Presenter extends BaseContract.BasePresenter<View> {
        void getAd();

        void getCatagory();
    }
}

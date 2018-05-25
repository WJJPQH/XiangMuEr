package com.example.com.jingdong_demo.mine.contract;


import com.example.com.jingdong_demo.base.BaseContract;
import com.example.com.jingdong_demo.bean.AddrsBean;

import java.util.List;

public interface MakeSureOrderContract {
    interface View extends BaseContract.BaseView {
        void addrsSuccess(List<AddrsBean.DataBean> list);

        void createOrderSuccess(String msg);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getAddrs(String uid, String token);

        void createOrder(String uid, String price, String token);
    }
}

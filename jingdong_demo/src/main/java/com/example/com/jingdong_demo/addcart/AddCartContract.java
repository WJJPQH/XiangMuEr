package com.example.com.jingdong_demo.addcart;

import com.example.com.jingdong_demo.base.BaseContract;

public interface AddCartContract {
    interface View extends BaseContract.BaseView{
        void onSuccess(String str);
    }
    interface  Presenter extends BaseContract.BasePresenter<View>{
        void addCart(String uid,String pid,String token);
    }
}

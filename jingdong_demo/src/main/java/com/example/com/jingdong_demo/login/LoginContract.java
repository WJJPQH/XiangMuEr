package com.example.com.jingdong_demo.login;


import com.example.com.jingdong_demo.base.BaseContract;
import com.example.com.jingdong_demo.bean.UserBean;

public interface LoginContract {
    interface View extends BaseContract.BaseView {
        void loginSuccess(UserBean userBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void login(String mobile, String password);
    }
}

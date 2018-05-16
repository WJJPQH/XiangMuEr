package com.example.com.jingdong_demo.base;

public interface BaseContract {

    interface BasePresenter<T extends BaseView>{
        void attchView(T view);

        void detachView();
    }

    interface BaseView{
        void showLoading();
        void dismissLoading();
    }
}

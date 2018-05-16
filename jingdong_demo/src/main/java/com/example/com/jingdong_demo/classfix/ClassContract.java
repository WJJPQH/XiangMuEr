package com.example.com.jingdong_demo.classfix;

import com.example.com.jingdong_demo.base.BaseContract;
import com.example.com.jingdong_demo.bean.CatagoryBean;
import com.example.com.jingdong_demo.bean.ProductCatagoryBean;

public interface ClassContract {
    interface View extends BaseContract.BaseView {
        void getProductCatagorySuccess(ProductCatagoryBean productCatagoryBean);

        void getCatagorySuccess(CatagoryBean catagoryBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getProductCatagory(String cid);

        void getCatagory();
    }
}

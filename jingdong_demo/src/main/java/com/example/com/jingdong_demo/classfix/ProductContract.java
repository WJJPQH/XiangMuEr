package com.example.com.jingdong_demo.classfix;

import com.example.com.jingdong_demo.base.BaseContract;
import com.example.com.jingdong_demo.bean.ProductsBean;

public interface ProductContract {
    interface View extends BaseContract.BaseView{
        void getProdutSuccess(ProductsBean productsBean);
    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getProduct(String pscid);
    }
}

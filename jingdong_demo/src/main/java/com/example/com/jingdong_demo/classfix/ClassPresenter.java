package com.example.com.jingdong_demo.classfix;


import com.example.com.jingdong_demo.base.BasePresenter;
import com.example.com.jingdong_demo.bean.CatagoryBean;
import com.example.com.jingdong_demo.bean.ProductCatagoryBean;
import com.example.com.jingdong_demo.net.CatagoryApi;
import com.example.com.jingdong_demo.net.ProductsApi;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ClassPresenter extends BasePresenter<ClassContract.View> implements ClassContract.Presenter {
    private ProductsApi productsApi;
    private CatagoryApi catagoryApi;

    @Inject
    public ClassPresenter(ProductsApi productsApi, CatagoryApi catagoryApi) {
        this.productsApi = productsApi;
        this.catagoryApi = catagoryApi;
    }


    @Override
    public void getProductCatagory(String cid) {
        productsApi.getProductCatagory(cid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ProductCatagoryBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ProductCatagoryBean productCatagoryBean) {
                        if (mView!=null){
                            mView.getProductCatagorySuccess(productCatagoryBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getCatagory() {
        catagoryApi.getCatagory()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<CatagoryBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CatagoryBean catagoryBean) {
                        if (mView!=null){
                            mView.getCatagorySuccess(catagoryBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

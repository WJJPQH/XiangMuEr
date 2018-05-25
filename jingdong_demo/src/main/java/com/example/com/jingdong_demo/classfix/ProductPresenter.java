package com.example.com.jingdong_demo.classfix;

import com.example.com.jingdong_demo.base.BaseContract;
import com.example.com.jingdong_demo.base.BasePresenter;
import com.example.com.jingdong_demo.bean.ProductsBean;
import com.example.com.jingdong_demo.net.ProductApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class ProductPresenter extends BasePresenter<ProductContract.View> implements ProductContract.Presenter {
    private ProductApi productApi;
    @Inject
    public ProductPresenter(ProductApi productApi) {
        this.productApi = productApi;
    }

    @Override
    public void getProduct(String pscid) {
        productApi.getProduct(pscid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ProductsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ProductsBean productsBean) {
                        mView.getProdutSuccess(productsBean);
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

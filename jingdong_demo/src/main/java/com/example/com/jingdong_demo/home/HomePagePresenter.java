package com.example.com.jingdong_demo.home;



import com.example.com.jingdong_demo.base.BasePresenter;
import com.example.com.jingdong_demo.bean.AdBean;
import com.example.com.jingdong_demo.bean.CatagoryBean;
import com.example.com.jingdong_demo.net.AdApi;
import com.example.com.jingdong_demo.net.CatagoryApi;


import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomePagePresenter extends BasePresenter<HomePageContract.View> implements HomePageContract.Presenter {
    private AdApi adApi;
    private CatagoryApi catagoryApi;

    @Inject
    public HomePagePresenter(AdApi adApi, CatagoryApi catagoryApi) {
        this.adApi = adApi;
        this.catagoryApi = catagoryApi;
    }

    @Override
    public void getAd() {
        adApi.getAd()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AdBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AdBean adBean) {
                         mView.getAdSuccess(adBean);
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
                        mView.getCatagorySuccess(catagoryBean);
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

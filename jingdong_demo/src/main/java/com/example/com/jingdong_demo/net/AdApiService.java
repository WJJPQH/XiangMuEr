package com.example.com.jingdong_demo.net;

import com.example.com.jingdong_demo.bean.AdBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface AdApiService {
    @GET("ad/getAd")
    Observable<AdBean> getAd();
}

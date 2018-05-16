package com.example.com.jingdong_demo.net;

import com.example.com.jingdong_demo.bean.CatagoryBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface CatagoryApiService {
    @GET("product/getCatagory")
    Observable<CatagoryBean> getCatagory();
}

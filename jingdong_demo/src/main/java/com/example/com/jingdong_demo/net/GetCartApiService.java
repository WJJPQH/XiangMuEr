package com.example.com.jingdong_demo.net;

import com.example.com.jingdong_demo.bean.GetCartsBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface GetCartApiService {
    @FormUrlEncoded
    @POST("product/getCarts")
    Observable<GetCartsBean> getCarts(@Field("uid") String uid,@Field("Token")String token);
}

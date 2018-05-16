package com.example.com.jingdong_demo.net;

import com.example.com.jingdong_demo.bean.ProductCatagoryBean;


import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ProductsApiService {
    @FormUrlEncoded
    @POST("product/getProductCatagory")
    Observable<ProductCatagoryBean> getProductCatagory(@Field("cid") String cid);
}

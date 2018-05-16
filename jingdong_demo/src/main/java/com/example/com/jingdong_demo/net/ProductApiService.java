package com.example.com.jingdong_demo.net;

import com.example.com.jingdong_demo.base.BaseContract;
import com.example.com.jingdong_demo.bean.ProductsBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ProductApiService {
    @FormUrlEncoded
    @POST("product/getProducts")
    Observable<ProductsBean> getProduct(@Field("pscid") String pscid);
}

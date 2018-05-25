package com.example.com.jingdong_demo.net;

import com.example.com.jingdong_demo.bean.AddrsBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AddrsApiService {
    @FormUrlEncoded
    @POST("user/getAddrs")
    Observable<AddrsBean> getAddrs(@Field("uid") String uid,
                                   @Field("token") String token);

}

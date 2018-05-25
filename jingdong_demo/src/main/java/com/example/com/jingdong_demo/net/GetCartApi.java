package com.example.com.jingdong_demo.net;

import com.example.com.jingdong_demo.bean.GetCartsBean;

import io.reactivex.Observable;

public class GetCartApi {
    private static GetCartApi getCartApi;
    private GetCartApiService getCartApiService;

    public GetCartApi(GetCartApiService getCartApiService) {
        this.getCartApiService = getCartApiService;
    }

    public static GetCartApi getGetCartApi(GetCartApiService getCartApiService) {
        if (getCartApi==null){
            getCartApi = new GetCartApi(getCartApiService);
        }
        return getCartApi;
    }
    public Observable<GetCartsBean> getCartgory(String uid,String token){
        return getCartApiService.getCarts(uid, token);
    }
}

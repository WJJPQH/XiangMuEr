package com.example.com.jingdong_demo.net;

import com.example.com.jingdong_demo.bean.BaseBean;

import io.reactivex.Observable;

public class AddCartApi {
    private static AddCartApi addCartApi;
    private AddCartService addCartService;

    public AddCartApi(AddCartService addCartService) {
        this.addCartService = addCartService;
    }

    public static AddCartApi getAddCartApi(AddCartService addCartService) {
        if (addCartApi==null){
            addCartApi = new AddCartApi(addCartService);
        }
        return addCartApi;
    }
    public Observable<BaseBean> getCatagory(String uid,String pid,String token){

        return addCartService.addCart(uid, pid, token);
    }
}

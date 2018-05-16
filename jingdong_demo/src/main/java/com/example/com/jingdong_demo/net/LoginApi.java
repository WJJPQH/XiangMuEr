package com.example.com.jingdong_demo.net;

import com.example.com.jingdong_demo.bean.UserBean;

import io.reactivex.Observable;


public class LoginApi {
    private static LoginApi loginApi;
    private LoginApiService loginApiService;

    private LoginApi(LoginApiService loginApiService){
        this.loginApiService = loginApiService;
    }

    public static LoginApi getLoginApi(LoginApiService loginApiService) {
        if (loginApi==null){
            loginApi = new LoginApi(loginApiService);
        }
        return loginApi;
    }
    public Observable<UserBean> login(String mobile,String password){
        return loginApiService.login(mobile, password);
    }
}

package com.example.com.jingdong_demo.module;

import com.example.com.jingdong_demo.net.AdApi;
import com.example.com.jingdong_demo.net.AdApiService;
import com.example.com.jingdong_demo.net.Api;
import com.example.com.jingdong_demo.net.CatagoryApi;
import com.example.com.jingdong_demo.net.CatagoryApiService;
import com.example.com.jingdong_demo.net.LoginApi;
import com.example.com.jingdong_demo.net.LoginApiService;
import com.example.com.jingdong_demo.net.ProductApi;
import com.example.com.jingdong_demo.net.ProductApiService;
import com.example.com.jingdong_demo.net.ProductsApi;
import com.example.com.jingdong_demo.net.ProductsApiService;

import java.util.concurrent.TimeUnit;



import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class HttpModule {
    @Provides
    OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient.Builder()
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS);
    }

    @Provides
    LoginApi provideLoginApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        LoginApiService loginApiService = retrofit.create(LoginApiService.class);
        return LoginApi.getLoginApi(loginApiService);
    }

    @Provides
    AdApi provideAdApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        AdApiService adApiService = retrofit.create(AdApiService.class);
        return AdApi.getAdApi(adApiService);
    }

    @Provides
    CatagoryApi provideCatagoryApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        CatagoryApiService catagoryApiService = retrofit.create(CatagoryApiService.class);
        return CatagoryApi.getCatagoryApi(catagoryApiService);
    }
    @Provides
    ProductsApi provideProductsApi(OkHttpClient.Builder builder){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        ProductsApiService productsApiService = retrofit.create(ProductsApiService.class);
        return ProductsApi.getProductsApi(productsApiService);
    }
    @Provides
    ProductApi provideProductApi(OkHttpClient.Builder builder){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        ProductApiService productApiService = retrofit.create(ProductApiService.class);
        return ProductApi.getProductApi(productApiService);
    }
}

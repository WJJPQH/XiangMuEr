package com.example.com.jingdong_demo.net;

import com.example.com.jingdong_demo.bean.ProductCatagoryBean;

import io.reactivex.Observable;

public class ProductsApi {
    private static ProductsApi productsApi;
    private ProductsApiService productsApiService;

    public ProductsApi(ProductsApiService productsApiService) {
        this.productsApiService = productsApiService;
    }
    public static ProductsApi getProductsApi(ProductsApiService productsApiService){

        if (productsApi==null){
            productsApi= new ProductsApi(productsApiService);
        }
        return productsApi;
    }
    public Observable<ProductCatagoryBean> getProductCatagory(String cid){

        return productsApiService.getProductCatagory(cid);
    }
}

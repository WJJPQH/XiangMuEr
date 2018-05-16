package com.example.com.jingdong_demo.net;

import com.example.com.jingdong_demo.bean.ProductsBean;

import io.reactivex.Observable;

public class ProductApi {
    private static ProductApi productApi;
    private ProductApiService productApiService;

    public ProductApi(ProductApiService productApiService) {
        this.productApiService = productApiService;
    }

    public static ProductApi getProductApi(ProductApiService productApiService) {
        if (productApi==null){
            productApi = new ProductApi(productApiService);
        }
        return productApi;
    }
    public Observable<ProductsBean> getProduct(String pscid){

        return productApiService.getProduct(pscid);
    }
}

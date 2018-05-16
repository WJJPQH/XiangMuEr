package com.example.com.jingdong_demo.classfix;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.com.jingdong_demo.R;
import com.example.com.jingdong_demo.base.BaseActivity;
import com.example.com.jingdong_demo.bean.ProductsBean;
import com.example.com.jingdong_demo.component.DaggerHttpComponent;
import com.example.com.jingdong_demo.module.HttpModule;
import com.example.com.jingdong_demo.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.Arrays;
import java.util.List;

public class XiangQingActivity extends BaseActivity<ProductPresenter> implements View.OnClickListener,ProductContract.View {
    private Banner banner;
    private ImageView back;
    private ImageView share;
    private TextView t1;
    private TextView t2;
    private TextView t3;
    private int pscid;
    private TextView add_cart;
    private TextView watch_cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        pscid = intent.getIntExtra("pscid",1);
        initView();
        mPresenter.getProduct(pscid+"");
    }
    @Override
    public int getContentLayout() {
        return R.layout.activity_xiang_qing;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }

    private void initView() {
        banner = findViewById(R.id.banner);
        back = findViewById(R.id.detail_image_back);
        t1 = findViewById(R.id.detail_title);
        t2 = findViewById(R.id.detail_yuan_price);
        t3 = findViewById(R.id.detail_bargin_price);
        back  =findViewById(R.id.detail_image_back);
        share = findViewById(R.id.detail_share);
        add_cart = findViewById(R.id.detai_add_cart);
        watch_cart = findViewById(R.id.watch_cart);
        back.setOnClickListener(this);
        share.setOnClickListener(this);
        add_cart.setOnClickListener(this);
        watch_cart.setOnClickListener(this);
        initBanner();
    }

    private void initBanner() {
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setImageLoader(new GlideImageLoader());
        banner.isAutoPlay(true);
        banner.setDelayTime(2500);
        banner.setIndicatorGravity(BannerConfig.CENTER);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void getProdutSuccess(ProductsBean productsBean) {
        List<ProductsBean.DataBean> list = productsBean.getData();

        for (int i = 0; i <list.size() ; i++) {
            banner.setImageLoader(new GlideImageLoader());
            String[] imgs = list.get(i).getImages().split("\\|");
            banner.setImages(Arrays.asList(imgs));
            banner.start();
            t1.setText(list.get(i).getTitle());
            t2.setText("原价："+list.get(i).getPrice());
            t3.setText("现价:"+list.get(i).getBargainPrice());
            t2.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }



}

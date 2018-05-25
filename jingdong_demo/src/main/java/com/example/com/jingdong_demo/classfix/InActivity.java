package com.example.com.jingdong_demo.classfix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.com.jingdong_demo.R;
import com.example.com.jingdong_demo.adapter.InAdapter;
import com.example.com.jingdong_demo.base.BaseActivity;
import com.example.com.jingdong_demo.bean.ProductsBean;
import com.example.com.jingdong_demo.component.DaggerHttpComponent;
import com.example.com.jingdong_demo.module.HttpModule;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class InActivity extends BaseActivity<ProductPresenter> implements ProductContract.View {

    private XRecyclerView rvIn;
    private int pscid;
    private boolean isRefresh = true;
    private InAdapter adapter;
    public static final int LISTACTIVITY = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        pscid = intent.getIntExtra("pscid",0);
        initView();
        mPresenter.getProduct(pscid+"");

    }
    @Override
    public int getContentLayout() {
        return R.layout.activity_in;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }

    public void initView(){
        rvIn = findViewById(R.id.rvIn);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvIn.setLayoutManager(layoutManager);
        rvIn.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                isRefresh = true;
                mPresenter.getProduct(pscid+"");
            }

            @Override
            public void onLoadMore() {
                isRefresh = false;
                mPresenter.getProduct(pscid+"");
            }
        });
    }

    @Override
    public void getProdutSuccess(ProductsBean productsBean) {
        List<ProductsBean.DataBean> list = productsBean.getData();
        final List<ProductsBean.DataBean> tempList = new ArrayList<>();
        tempList.addAll(list);
        //创建适配器
        if (isRefresh) {
            adapter = new InAdapter(this, list);
            rvIn.setAdapter(adapter);
            adapter.refresh(tempList);
            rvIn.refreshComplete();//设置刷新完成
        } else {
            if (adapter != null) {
                //判断适配器是否创建过
                adapter.loadMore(tempList);
                rvIn.loadMoreComplete();//设置加载更多完成
            }
        }

        if (adapter == null) {
            return;
        }
        adapter.setOnListItemClickListener(new InAdapter.OnListItemClickListener() {
            @Override
            public void OnItemClick(ProductsBean.DataBean dataBean) {
                Intent intent = new Intent(InActivity.this, XiangQingActivity.class);
                intent.putExtra("bean", dataBean);
                intent.putExtra("flag", LISTACTIVITY);
                startActivity(intent);
            }
        });

    }


}

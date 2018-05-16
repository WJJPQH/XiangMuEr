package com.example.com.jingdong_demo.classfix;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ExpandableListView;

import com.example.com.jingdong_demo.R;
import com.example.com.jingdong_demo.adapter.ElvAdapter;
import com.example.com.jingdong_demo.adapter.RvleftAdapter;
import com.example.com.jingdong_demo.base.BaseFragment;
import com.example.com.jingdong_demo.bean.CatagoryBean;
import com.example.com.jingdong_demo.bean.ProductCatagoryBean;
import com.example.com.jingdong_demo.component.DaggerHttpComponent;
import com.example.com.jingdong_demo.inter.OnItemClickLisenter;
import com.example.com.jingdong_demo.module.HttpModule;

import java.util.ArrayList;
import java.util.List;

public class ClassApiFragment extends BaseFragment<ClassPresenter> implements ClassContract.View {

    private RecyclerView rvC;
    private ExpandableListView expand;
    private int cid=1;
    @Override
    public int getContentLayout() {
        return R.layout.fragment_class;
    }
    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {
        rvC = view.findViewById(R.id.rvC);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        rvC.setLayoutManager(layoutManager);
        expand = view.findViewById(R.id.expand);
        mPresenter.getCatagory();
        mPresenter.getProductCatagory(cid+"");
    }

    @Override
    public void getProductCatagorySuccess(ProductCatagoryBean productCatagoryBean) {
        List<ProductCatagoryBean.DataBean> list = productCatagoryBean.getData();
        List<String> grouplist = new ArrayList<>();
        List<List<ProductCatagoryBean.DataBean.ListBean>> childlist = new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            grouplist.add(list.get(i).getName());
            childlist.add(list.get(i).getList());
        }
        ElvAdapter elvAdapter = new ElvAdapter(getContext(),grouplist,childlist);
        expand.setAdapter(elvAdapter);
    }

    @Override
    public void getCatagorySuccess(final CatagoryBean catagoryBean) {
        final List<CatagoryBean.DataBean> list = catagoryBean.getData();
        final RvleftAdapter rvleftAdapter = new RvleftAdapter(getContext(),list);
        rvC.setAdapter(rvleftAdapter);
        rvleftAdapter.setOnItemClick(new OnItemClickLisenter() {
            @Override
            public void onItemClick(int position) {
                cid = list.get(position).getCid();
            }

            @Override
            public void onLongItemClick(int position) {

            }
        });
    }






}

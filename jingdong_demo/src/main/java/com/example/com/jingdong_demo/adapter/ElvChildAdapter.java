package com.example.com.jingdong_demo.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.com.jingdong_demo.R;
import com.example.com.jingdong_demo.bean.ProductCatagoryBean;
import com.example.com.jingdong_demo.inter.OnItemClickLisenter;

import java.util.ArrayList;
import java.util.List;

public class ElvChildAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<ProductCatagoryBean.DataBean.ListBean> listBeans;
    private LayoutInflater inflater;
    private OnItemClickLisenter onItemClickLisenter;


    public ElvChildAdapter(Context context, List<ProductCatagoryBean.DataBean.ListBean> listBeans) {
        this.context = context;
        this.listBeans = listBeans;
        inflater = LayoutInflater.from(context);
    }
    public void setOnItemClickLisenter(OnItemClickLisenter onItemClickLisenter){
        this.onItemClickLisenter = onItemClickLisenter;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rvclass_item, parent, false);
        ElvRvAdapterViewHolder elvRvAdapterViewHolder = new ElvRvAdapterViewHolder(view);
        return elvRvAdapterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ElvRvAdapterViewHolder elvRvAdapterViewHolder = (ElvRvAdapterViewHolder) holder;
        ProductCatagoryBean.DataBean.ListBean listBean = listBeans.get(position);

        elvRvAdapterViewHolder.iv.setImageURI(Uri.parse(listBean.getIcon()));
        elvRvAdapterViewHolder.tv.setText(listBean.getName());
        elvRvAdapterViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickLisenter!=null){
                    onItemClickLisenter.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    class ElvRvAdapterViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView tv;
        private LinearLayout ll;
        public ElvRvAdapterViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}

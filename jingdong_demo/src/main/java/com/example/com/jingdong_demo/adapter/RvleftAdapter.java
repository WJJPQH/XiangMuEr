package com.example.com.jingdong_demo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.com.jingdong_demo.R;
import com.example.com.jingdong_demo.bean.CatagoryBean;
import com.example.com.jingdong_demo.inter.OnItemClickLisenter;

import java.util.ArrayList;
import java.util.List;

public class RvleftAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<CatagoryBean.DataBean> list;
    private LayoutInflater inflater;
    private OnItemClickLisenter onItemClick;
    public RvleftAdapter(Context context, List<CatagoryBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    public void setOnItemClick(OnItemClickLisenter onItemClick) {
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rvleft,parent,false);
        ClassViewHoler classViewHoler = new ClassViewHoler(view);
        return classViewHoler;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ClassViewHoler classViewHoler = (ClassViewHoler) holder;
        CatagoryBean.DataBean dataBean = list.get(position);
        classViewHoler.text.setText(dataBean.getName());
        if (dataBean.isChecked()) {
            classViewHoler.text.setTextColor(Color.RED);
            classViewHoler.text.setBackgroundColor(Color.GRAY);
        } else {
            classViewHoler.text.setTextColor(Color.BLACK);
            classViewHoler.text.setBackgroundColor(Color.WHITE);
        }


        classViewHoler.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClick != null) {
                    onItemClick.onItemClick(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ClassViewHoler extends RecyclerView.ViewHolder {
        private TextView text;
        public ClassViewHoler(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
        }
    }
    public void changeCheck(int position, boolean bool) {
        //先还原一下
        for (int i = 0;i<list.size();i++){
            list.get(i).setChecked(false);
        }
        CatagoryBean.DataBean dataBean = list.get(position);
        dataBean.setChecked(bool);
        //刷新界面
        notifyDataSetChanged();
    }
}

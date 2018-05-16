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
    private List<Boolean> isClicks;
    private LayoutInflater inflater;
    private OnItemClickLisenter onItemClick;
    public RvleftAdapter(Context context, List<CatagoryBean.DataBean> list) {
        this.context = context;
        this.list = list;
        isClicks = new ArrayList<>();
        for(int i = 0;i<list.size();i++){
            if(i==0){
                isClicks.add(true);
            }
            isClicks.add(false);
        }
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
        if(isClicks.get(position)){
            classViewHoler.text.setTextColor(Color.RED);
        }else{
            classViewHoler.text.setTextColor(Color.BLACK);
        }
        //设置点击
        classViewHoler.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClick!=null){
                    for(int i = 0; i <isClicks.size();i++){
                        isClicks.set(i,false);
                    }
                    isClicks.set(position,true);
                    notifyDataSetChanged();
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
}

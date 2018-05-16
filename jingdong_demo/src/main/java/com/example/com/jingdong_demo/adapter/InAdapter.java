package com.example.com.jingdong_demo.adapter;


import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.com.jingdong_demo.R;
import com.example.com.jingdong_demo.bean.ProductsBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class InAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ProductsBean.DataBean> list;
    private LayoutInflater inflater;
    private OnListItemClickListener onListItemClickListener;

    public interface OnListItemClickListener {
        void OnItemClick(ProductsBean.DataBean dataBean);
    }

    public InAdapter(Context context, List<ProductsBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    public void setOnListItemClickListener(OnListItemClickListener onListItemClickListener) {
        this.onListItemClickListener = onListItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.in_item,parent,false);
        InViewHolder inViewHolder = new InViewHolder(view);
        return inViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        InViewHolder inViewHolder = (InViewHolder) holder;
        final ProductsBean.DataBean dataBean = list.get(position);
        String s = list.get(position).getImages().split("\\|")[0];
        inViewHolder.iv.setImageURI(Uri.parse(s));
        inViewHolder.tvTitle.setText(list.get(position).getTitle());
        inViewHolder.tvPrice.setText(list.get(position).getPrice()+"");
        inViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onListItemClickListener.OnItemClick(dataBean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class InViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView iv;
        private TextView tvTitle;
        private TextView tvPrice;
        private LinearLayout ll;
        public InViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            ll = itemView.findViewById(R.id.ll);
        }
    }
    public void refresh(List<ProductsBean.DataBean> templist) {
        this.list.clear();
        this.list.addAll(templist);
        notifyDataSetChanged();
    }

    /**
     * 加载更多
     *
     * @param list
     */
    public void loadMore(List<ProductsBean.DataBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }
}

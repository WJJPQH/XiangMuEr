package com.example.com.jingdong_demo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.com.jingdong_demo.R;
import com.example.com.jingdong_demo.bean.ProductCatagoryBean;
import com.example.com.jingdong_demo.classfix.InActivity;
import com.example.com.jingdong_demo.inter.OnItemClickLisenter;

import java.util.List;

public class ElvAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> grouplist;
    private List<List<ProductCatagoryBean.DataBean.ListBean>> childlist;
    private LayoutInflater inflater;

    public ElvAdapter(Context context, List<String> grouplist,List<List<ProductCatagoryBean.DataBean.ListBean>> childlist) {
        this.context = context;
        this.grouplist = grouplist;
        this.childlist = childlist;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return grouplist.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return grouplist.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return childlist.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null) {
            groupViewHolder = new GroupViewHolder();
            convertView = inflater.inflate(R.layout.class_item, null);
            groupViewHolder.tv = convertView.findViewById(R.id.tv);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        groupViewHolder.tv.setText(grouplist.get(i));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup
            parent) {
        ChildViewHolder childViewHolder;
        if (convertView == null) {
            childViewHolder = new ChildViewHolder();
            convertView = inflater.inflate(R.layout.elv_rv, null);
            childViewHolder.rv = convertView.findViewById(R.id.rv);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        //显示数据
        final List<ProductCatagoryBean.DataBean.ListBean> listBeans = childlist.get(groupPosition);
        //设置布局管理器
        childViewHolder.rv.setLayoutManager(new GridLayoutManager(context, 3));
        //设置适配器
        ElvChildAdapter elvRvAdapter = new ElvChildAdapter(context, listBeans);
        childViewHolder.rv.setAdapter(elvRvAdapter);
        elvRvAdapter.setOnItemClickLisenter(new OnItemClickLisenter() {
            @Override
            public void onItemClick(int position) {
                Intent intent;
                intent = new Intent(context,InActivity.class);
                int pscid = listBeans.get(position).getPscid();
                intent.putExtra("pscid",pscid);
                context.startActivity(intent);
            }

            @Override
            public void onLongItemClick(int position) {

            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
    class GroupViewHolder {
        TextView tv;
    }

    class ChildViewHolder {
        RecyclerView rv;
    }
}

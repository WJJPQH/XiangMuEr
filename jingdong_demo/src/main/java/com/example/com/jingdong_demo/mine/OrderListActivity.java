package com.example.com.jingdong_demo.mine;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.example.com.jingdong_demo.R;
import com.example.com.jingdong_demo.base.BaseActivity;
import com.example.com.jingdong_demo.mine.fragment.FragmentAllOrder;
import com.example.com.jingdong_demo.mine.fragment.FragmentWaitOrder;

public class OrderListActivity extends BaseActivity {

    private ImageView mDetailImageBack;
    private ImageView mSanDianPop;
    private RelativeLayout mDetaiRelative;
    /**
     * 全部
     */
    private RadioButton mRadio01;
    /**
     * 待支付
     */
    private RadioButton mRadio02;
    /**
     * 已支付
     */
    private RadioButton mRadio03;
    /**
     * 已取消
     */
    private RadioButton mRadio04;
    private RadioGroup mRadioGroup;
    private FrameLayout mFrameContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        mDetailImageBack = (ImageView) findViewById(R.id.detail_image_back);
        mSanDianPop = (ImageView) findViewById(R.id.san_dian_pop);
        mDetaiRelative = (RelativeLayout) findViewById(R.id.detai_relative);
        mRadio01 = (RadioButton) findViewById(R.id.radio_01);
        mRadio02 = (RadioButton) findViewById(R.id.radio_02);
        mRadio03 = (RadioButton) findViewById(R.id.radio_03);
        mRadio04 = (RadioButton) findViewById(R.id.radio_04);
        mRadioGroup = (RadioGroup) findViewById(R.id.radio_group);
        mFrameContent = (FrameLayout) findViewById(R.id.frame_content);

        //加载“全部”fragment
        FragmentAllOrder fragmentAllOrder = new FragmentAllOrder();

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.frame_content,fragmentAllOrder)
                .commit();

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_01://全部
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content,new FragmentAllOrder()).commit();
                        break;
                    case R.id.radio_02://待支付
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content,new FragmentWaitOrder()).commit();
                        break;
                    case R.id.radio_03://已支付
                        // getSupportFragmentManager().beginTransaction().replace(R.id.frame_content,new FragmentAlreadyPayOrder()).commit();
                        break;
                    case R.id.radio_04://已取消
                        //  getSupportFragmentManager().beginTransaction().replace(R.id.frame_content,new FragmentCacelOrder()).commit();
                        break;
                }
            }
        });
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_order_list;
    }

    @Override
    public void inject() {

    }
}


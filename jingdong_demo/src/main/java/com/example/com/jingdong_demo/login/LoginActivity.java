package com.example.com.jingdong_demo.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.com.jingdong_demo.R;
import com.example.com.jingdong_demo.base.BaseActivity;
import com.example.com.jingdong_demo.bean.UserBean;
import com.example.com.jingdong_demo.component.DaggerHttpComponent;
import com.example.com.jingdong_demo.module.HttpModule;
import com.example.com.jingdong_demo.utils.SharedPreferencesUtils;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity<LoginPresenter> implements View.OnClickListener,LoginContract.View {

    private EditText mMobile;
    private EditText mPassword;
    private Button mBtLogin;
    private ImageView imgqq;
    private Button btCancle;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        initView();
    }

    public void initView() {
        mMobile = (EditText) findViewById(R.id.mobile);
        mPassword = (EditText) findViewById(R.id.password);
        mBtLogin = (Button) findViewById(R.id.btLogin);
        btCancle =findViewById(R.id.btCancle);
        imgqq = findViewById(R.id.imgqq);
        btCancle.setOnClickListener(this);
        imgqq.setOnClickListener(this);
        mBtLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            default:
                break;
            case R.id.btLogin:
                //需要调用P层，去完成接口调用
                String mobile = mMobile.getText().toString();
                String password = mPassword.getText().toString();
                mPresenter.login(mobile, password);
                break;
            case R.id.imgqq:
                UMShareAPI mShareAPI = UMShareAPI.get(LoginActivity.this);
                mShareAPI.getPlatformInfo(LoginActivity.this, SHARE_MEDIA.QQ, umAuthListener);
                finish();
                break;
        }
    }
    UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {
            Log.e("onStart", "onStart");
        }

        //授权成功了。map里面就封装了一些qq信息
        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {

            String uid = map.get("uid");
            String openid = map.get("openid");//微博没有
            String unionid = map.get("unionid");//微博没有
            String access_token = map.get("access_token");
            String refresh_token = map.get("refresh_token");//微信,qq,微博都没有获取到
            String expires_in = map.get("expires_in");
             name = map.get("name");
            String gender = map.get("gender");//性别
            String iconurl = map.get("iconurl");//头像
            Toast.makeText(getApplicationContext(), "name=" + name + ",gender=" + gender, Toast.LENGTH_SHORT).show();
        }

        //授权失败
        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
            Log.e("onError", "onError");
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {
            Log.e("onCancel", "onCancel");
        }

    };
    //授权回调
    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }

    @Override
    public void loginSuccess(UserBean userBean) {
        Toast.makeText(LoginActivity.this, userBean.getMsg(), Toast.LENGTH_SHORT).show();
        SharedPreferencesUtils.setParam(LoginActivity.this,"uid",userBean.getData().getUid() + "");
        SharedPreferencesUtils.setParam(LoginActivity.this,"name",userBean.getData().getUsername() + "");
        SharedPreferencesUtils.setParam(LoginActivity.this,"iconUrl",userBean.getData().getIcon() + "");
        SharedPreferencesUtils.setParam(LoginActivity.this,"token",userBean.getData().getToken() + "");
        SharedPreferencesUtils.setParam(LoginActivity.this,"mobile",mMobile.getText() + "");
//        SharedPreferencesUtils.setParam(LoginActivity.this,"name",name+"");
        LoginActivity.this.finish();
    }
}

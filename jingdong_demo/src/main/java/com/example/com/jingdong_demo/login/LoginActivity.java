package com.example.com.jingdong_demo.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.com.jingdong_demo.R;
import com.example.com.jingdong_demo.base.BaseActivity;
import com.example.com.jingdong_demo.bean.UserBean;

public class LoginActivity extends BaseActivity<LoginPresenter> implements View.OnClickListener,LoginContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public int getContentLayout() {
        return 0;
    }

    @Override
    public void inject() {
    }

    @Override
    public void loginSuccess(UserBean userBean) {

    }
}

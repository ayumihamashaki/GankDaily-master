package com.gudong.gankio.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gudong.gankio.R;
import com.gudong.gankio.presenter.SignInPresenter;
import com.gudong.gankio.presenter.UserFindPWDPresenter;
import com.gudong.gankio.ui.view.IBaseView;

public class UserFindPWDActivity extends BaseActivity<UserFindPWDPresenter> implements IBaseView {

    @Override
    protected void initKProgressHUD() {

    }

    @Override
    protected void initPresenter() {
        mPresenter = new UserFindPWDPresenter(this,this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_user_find_pwd;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.action_title_find_pwd),true);
    }

    @Override
    public void showLoading(boolean isShow) {

    }

    @Override
    public void doSomthing(String msg, int code) {

    }
}

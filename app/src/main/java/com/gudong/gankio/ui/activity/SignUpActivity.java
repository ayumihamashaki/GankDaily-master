package com.gudong.gankio.ui.activity;

import android.os.Bundle;
import com.gudong.gankio.R;
import com.gudong.gankio.presenter.SignUpPresenter;
import com.gudong.gankio.ui.view.IBaseView;


public class SignUpActivity  extends BaseActivity<SignUpPresenter> implements IBaseView {

    @Override
    protected void initKProgressHUD() {

    }

    @Override
    protected void initPresenter() {
        mPresenter = new SignUpPresenter(this, this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_sign_up;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.action_title_signup),true);
    }


    @Override
    public void showLoading(boolean isShow) {

    }

    @Override
    public void doSomthing(String msg, int code) {

    }
}

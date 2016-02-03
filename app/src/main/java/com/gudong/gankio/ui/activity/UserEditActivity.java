package com.gudong.gankio.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gudong.gankio.R;
import com.gudong.gankio.presenter.AboutUsPresenter;
import com.gudong.gankio.presenter.UserEditPresenter;
import com.gudong.gankio.ui.view.IBaseView;

/**
 * 用户编辑
 */
public class UserEditActivity extends BaseActivity<UserEditPresenter> implements IBaseView {


    @Override
    protected void initKProgressHUD() {

    }

    @Override
    protected void initPresenter() {
        mPresenter = new UserEditPresenter(this,this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_user_edit;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getResources().getString(R.string.action_title_user_edit),true);
    }

    @Override
    public void showLoading(boolean isShow) {
        if (mKProgressHUD == null) {
            throw new RuntimeException("请先初始化mKProgressHUD;");
        }
        if(isShow){
            mKProgressHUD.show();
        }else{
            mKProgressHUD.dismiss();
        }
    }

    @Override
    public void doSomthing(String msg, int code) {

    }
}

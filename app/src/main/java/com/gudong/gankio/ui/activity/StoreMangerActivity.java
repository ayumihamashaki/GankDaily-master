package com.gudong.gankio.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gudong.gankio.R;
import com.gudong.gankio.presenter.FeedPresenter;
import com.gudong.gankio.presenter.StoreMangerPresenter;
import com.gudong.gankio.ui.view.IBaseView;

public class StoreMangerActivity extends BaseActivity<StoreMangerPresenter> implements IBaseView {

    @Override
    protected void initKProgressHUD() {

    }

    @Override
    protected void initPresenter() {
        mPresenter = new StoreMangerPresenter(this,this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_store_manger;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setTitle(getResources().getString(R.string.action_title_mine_store),true);
    }

    @Override
    public void showLoading(boolean isShow) {

    }

    @Override
    public void doSomthing(String msg, int code) {

    }
}

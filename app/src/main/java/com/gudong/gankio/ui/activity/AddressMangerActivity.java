package com.gudong.gankio.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gudong.gankio.R;
import com.gudong.gankio.presenter.AddressMangerPresenter;
import com.gudong.gankio.presenter.StoreMangerPresenter;
import com.gudong.gankio.ui.view.IBaseView;

/**
 *  我的地址
 */
public class AddressMangerActivity extends BaseActivity<AddressMangerPresenter> implements IBaseView {

    @Override
    protected void initKProgressHUD() {

    }

    @Override
    protected void initPresenter() {
        mPresenter = new AddressMangerPresenter(this,this);
    }

    @Override
    protected int getLayout() {
        return  R.layout.activity_address_manger;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getResources().getString(R.string.action_title_mine_address), true);
    }

    @Override
    public void showLoading(boolean isShow) {

    }

    @Override
    public void doSomthing(String msg, int code) {

    }
}

package com.gudong.gankio.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gudong.gankio.R;
import com.gudong.gankio.presenter.AboutUsPresenter;
import com.gudong.gankio.presenter.AddressMangerPresenter;
import com.gudong.gankio.presenter.FeedPresenter;
import com.gudong.gankio.presenter.MinePresenter;
import com.gudong.gankio.ui.view.IBaseView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MineActivity extends BaseActivity<MinePresenter> implements IBaseView{

    @Bind(R.id.ly_menu_store)
    LinearLayout ly_menu_store;
    @Bind(R.id.mine_menu_address)
    LinearLayout mineMenuAddress;
    @Bind(R.id.mine_menu_collect)
    LinearLayout mineMenuCollect;
    @Bind(R.id.mine_menu_setting)
    LinearLayout mineMenuSetting;
    @Bind(R.id.iv_avatar)
    ImageView iv_avatar;

    @Override
    protected void initKProgressHUD() {

    }

    @Override
    protected void initPresenter() {
        mPresenter = new MinePresenter(this, this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_mine;
    }

    @Override
    public void showLoading(boolean isShow) {

    }

    @Override
    public void doSomthing(String msg, int code) {

    }

    @OnClick(R.id.ly_menu_store)
    public void toMineStore() {
        startActivity(new Intent(this, StoreMangerActivity.class));
    }

    @OnClick(R.id.mine_menu_address)
    public void toMineAddress() {
        startActivity(new Intent(this, AddressMangerActivity.class));
    }

    @OnClick(R.id.mine_menu_collect)
    public void toMineCollect() {
        startActivity(new Intent(this, CollectMangerActivity.class));
    }

    @OnClick(R.id.mine_menu_setting)
    public void toMineSetting() {
        startActivity(new Intent(this, SettingActivity.class));
    }

    @OnClick(R.id.iv_avatar)
    public void toAvatar() {
        startActivity(new Intent(this, UserEditActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}

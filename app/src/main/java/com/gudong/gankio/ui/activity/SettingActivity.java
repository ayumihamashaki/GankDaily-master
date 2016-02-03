package com.gudong.gankio.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.gudong.gankio.R;
import com.gudong.gankio.core.FPHelp;
import com.gudong.gankio.presenter.SettingPresenter;
import com.gudong.gankio.ui.event.RxBus;
import com.gudong.gankio.ui.event.UserEvent;
import com.gudong.gankio.ui.view.IBaseView;
import com.gudong.gankio.util.DebugUtil;
import com.kaopiz.kprogresshud.KProgressHUD;

import butterknife.Bind;
import butterknife.OnClick;
import rx.Subscription;
import rx.functions.Action1;

/**
 * 设置界面
 */
public class SettingActivity extends BaseActivity<SettingPresenter> implements IBaseView {


    @Bind(R.id.menu_setting_feedback)
    LinearLayout menuSettingFeedback;
    @Bind(R.id.menu_setting_provision)
    LinearLayout menuSettingProvision;
    @Bind(R.id.menu_setting_about)
    LinearLayout menuSettingAbout;
    @Bind(R.id.bt_logout)
    Button btLogout;

    @OnClick(R.id.bt_logout)
    public void btLogout() {
        mPresenter.logout();
    }


    @OnClick(R.id.menu_setting_feedback)
    public void toFeedback() {
        startActivity(new Intent(this, FeedbackActivity.class));
    }

    @OnClick(R.id.menu_setting_provision)
    public void toProvision() {
        startActivity(new Intent(this, ProvisionActivity.class));
    }

    @OnClick(R.id.menu_setting_about)
    public void toAboutUs() {
        startActivity(new Intent(this, AboutUsActivity.class));
    }

    @Override
    protected void initKProgressHUD() {
        mKProgressHUD = KProgressHUD.create(this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("请等待")
                .setDetailsLabel("正在加载数据...");
    }

    @Override
    protected void initPresenter() {
        mPresenter = new SettingPresenter(this, this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_setting;
    }

    public Subscription rxSubscription;
    @Override
    protected void onStart() {
        super.onStart();
        rxSubscription = RxBus.getInstance().toObserverable()
                .subscribe(
                        new Action1<RxBus.BusEvent>(){
                            @Override
                            public void call(RxBus.BusEvent busEvent) {
                                // TODO: TapEvent
                                if (busEvent instanceof UserEvent) {
                                    if(FPHelp.getInstance().isLogin()){
                                        DebugUtil.i(FPHelp.getInstance().getCurrentUser().cellphone);
                                        btLogout.setVisibility(View.VISIBLE);
                                    }else{
                                        btLogout.setVisibility(View.GONE);
                                    }
                                }
                            }
                        }
                        ,new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                // TODO: 处理异常
                            }
                        }
                );
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(!rxSubscription.isUnsubscribed()) {
            rxSubscription.unsubscribe();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getResources().getString(R.string.action_title_setting), true);
        initUI();
    }

    private void initUI() {
        //TODO update ui
        if(FPHelp.getInstance().isLogin()){
            btLogout.setVisibility(View.VISIBLE);
        }else{
            btLogout.setVisibility(View.GONE);
        }
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
        switch (code){
            case 4:
                finish();
                break;
            default:
                break;
        }
    }
}

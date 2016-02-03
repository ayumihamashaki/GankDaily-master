package com.gudong.gankio.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gudong.gankio.R;
import com.gudong.gankio.core.FPHelp;
import com.gudong.gankio.data.entity.User;
import com.gudong.gankio.presenter.HomeMineFragmentPresenter;
import com.gudong.gankio.ui.activity.AddressMangerActivity;
import com.gudong.gankio.ui.activity.CollectMangerActivity;
import com.gudong.gankio.ui.activity.SettingActivity;
import com.gudong.gankio.ui.activity.SignInActivity;
import com.gudong.gankio.ui.activity.StoreSignInActivity;
import com.gudong.gankio.ui.event.RxBus;
import com.gudong.gankio.ui.event.UserEvent;
import com.gudong.gankio.ui.view.IMineView;
import com.gudong.gankio.util.DebugUtil;
import com.gudong.gankio.util.ToastUtils;
import com.ogaclejapan.rx.binding.RxView;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by rmtic on 2016/1/20.
 */
public class HomeMineFragment extends BaseFragment<HomeMineFragmentPresenter> implements IMineView {

    private User user;
    @Bind(R.id.ly_menu_store)
    LinearLayout ly_menu_store;
    @Bind(R.id.mine_menu_address)
    LinearLayout mineMenuAddress;
    @Bind(R.id.mine_menu_collect)
    LinearLayout mineMenuCollect;
    @Bind(R.id.mine_menu_setting)
    LinearLayout mineMenuSetting;
    @Bind(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @Bind(R.id.iv_avatar)
    ImageView ivAvatar;
    @Bind(R.id.tv_username)
    TextView tv_username;
    @Bind(R.id.tv_menu_store)
    TextView tvMenuStore;







    @Bind(R.id.tv_signin)TextView tv_signin;
    @OnClick(R.id.tv_signin)
    public void TvSignIn(){
        // TODO 登录
        startActivity(new Intent(getActivity(),SignInActivity.class));
    }



















    @OnClick(R.id.mine_menu_setting)
    public void onMineMenuSetting() {
        startActivity(new Intent(getActivity(), SettingActivity.class));
    }

    @OnClick(R.id.mine_menu_collect)
    public void onMineMenuCollect() {
        startActivity(new Intent(getActivity(), CollectMangerActivity.class));
    }

    @OnClick(R.id.mine_menu_address)
    public void onMineMenuAddress() {
        startActivity(new Intent(getActivity(), AddressMangerActivity.class));
    }



    @OnClick(R.id.ly_menu_store)
    public void onLyMenuStore() {
        if (!FPHelp.getInstance().isLogin()) {
            startActivity(new Intent(getActivity(), SignInActivity.class));
        }
        if(user==null){
            ToastUtils.showLong("请先登录，在操作");
            return;
        }
        DebugUtil.i(user.storeStatus + "");
        switch (user.storeStatus) {
            case 3:
                //等待审核
                break;
            case 4:
                //管理店铺
                startActivity(new Intent(getActivity(),StoreSignInActivity.class));
                //startActivity(new Intent(getActivity(),MangerStoreActivity.class));
                break;
            default:
                startActivity(new Intent(getActivity(),StoreSignInActivity.class));
                tvMenuStore.setText("注册店铺");
                break;
        }
    }

    @Override
    protected void initPresenter() {
        mPresenter = new HomeMineFragmentPresenter(getActivity(), this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home_mine;
    }

    public Subscription rxSubscription;
    @Override
    public void onStart() {
        super.onStart();
        rxSubscription = RxBus.getInstance().toObserverable()
                .subscribe(
                        new Action1<RxBus.BusEvent>(){
                            @Override
                            public void call(RxBus.BusEvent busEvent) {
                                // TODO: TapEvent
                                if (busEvent instanceof UserEvent) {
                                    if(FPHelp.getInstance().isLogin()){
                                        ly_menu_store.setVisibility(View.VISIBLE);
                                        tv_username.setVisibility(View.VISIBLE);
                                        tv_signin.setVisibility(View.GONE);
                                        Picasso.with(getActivity())
                                                .load(FPHelp.getInstance().getBaseIMGUrl() + user.picture)
                                                .placeholder(R.drawable.biz_tie_comment_tag_default)
                                                .into(ivAvatar);
                                        mineMenuCollect.setVisibility(View.VISIBLE);
                                        mineMenuAddress.setVisibility(View.VISIBLE);

                                    }else{
                                        ly_menu_store.setVisibility(View.GONE);
                                        tv_username.setVisibility(View.GONE);
                                        tv_signin.setVisibility(View.VISIBLE);
                                        Picasso.with(getActivity())
                                                .load(R.drawable.biz_tie_comment_tag_default)
                                                .into(ivAvatar);
                                        mineMenuCollect.setVisibility(View.GONE);
                                        mineMenuAddress.setVisibility(View.GONE);
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
    public void onDestroy() {
        super.onDestroy();
        if(!rxSubscription.isUnsubscribed()) {
            rxSubscription.unsubscribe();
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mToolbar.setTitle(getString(R.string.action_title_mine));
        mToolbar.setVisibility(View.GONE);
        mPresenter.refresh();
        initUI();
    }

    private void initUI() {
        //TODO init ui
        if(FPHelp.getInstance().isLogin()){
            //在线
            ly_menu_store.setVisibility(View.VISIBLE);
            tv_username.setVisibility(View.VISIBLE);
            tv_signin.setVisibility(View.GONE);
            Picasso.with(getActivity())
                    .load(FPHelp.getInstance().getBaseIMGUrl() + user.picture+"?"+System.currentTimeMillis())
                    .placeholder(R.drawable.biz_tie_comment_tag_default)
                    .into(ivAvatar);
            mineMenuCollect.setVisibility(View.VISIBLE);
            mineMenuAddress.setVisibility(View.VISIBLE);
        }else{
            //离线
            ly_menu_store.setVisibility(View.GONE);
            tv_username.setVisibility(View.GONE);
            tv_signin.setVisibility(View.VISIBLE);
            Picasso.with(getActivity())
                    .load(R.drawable.biz_tie_comment_tag_default)
                    .into(ivAvatar);
            mineMenuCollect.setVisibility(View.GONE);
            mineMenuAddress.setVisibility(View.GONE);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void showLoading(boolean isShow) {

    }

    @Override
    public void doSomthing(String msg, int code) {

    }

    @Override
    public void onLine() {
        if (FPHelp.getInstance().getCurrentUser() != null) {
            user = FPHelp.getInstance().getCurrentUser();
            tv_username.setText(user.name);
            Picasso.with(getActivity())
                    .load(FPHelp.getInstance().getBaseIMGUrl() + user.picture)
                    .placeholder(R.drawable.biz_tie_comment_tag_default)
                    .into(ivAvatar);
            switch (user.storeStatus) {
                case 1:
                    break;
                default:
                    tvMenuStore.setText("注册店铺");
                    break;
            }

        }
    }

    @Override
    public void offLine() {

    }
}

package com.gudong.gankio.ui.activity;

import android.os.Bundle;

import com.gudong.gankio.R;
import com.gudong.gankio.ui.event.RxBus;
import com.gudong.gankio.ui.fragment.HomeLouxiaFragment;
import com.gudong.gankio.ui.fragment.HomeMessageFragment;
import com.gudong.gankio.ui.fragment.HomeMineFragment;
import com.gudong.gankio.ui.fragment.HomeOrderFragment;
import com.gudong.gankio.ui.widget.MyRadioGroup;
import com.gudong.gankio.util.ToastUtils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;
/**
 * 主页
 */
public class HomeActivity extends FragmentActivity {



    private HomeLouxiaFragment mhomeLouxiaFragment;
    private HomeMessageFragment mhomeMessageFragment;
    private HomeOrderFragment mHomeOrderFragment;
    private HomeMineFragment mhHomeMineFragment;

    //图标ID
    private int tabIds[] = new int[]{
            R.id.tab_rb_a,//楼下
            R.id.tab_rb_b,//消息
            R.id.tab_rb_c,//订单
            R.id.tab_rb_d,//我的
    };
    @Bind(R.id.tabs_rg)MyRadioGroup tabs_rg;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);


        tabs_rg.setOnCheckedChangeListener(new MyRadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(MyRadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                for (int i = 0; i < tabIds.length; i++) {
                    if (tabIds[i] == checkedId) {
                        setSelection(i);
                        break;
                    }
                }
            }
        });
        setSelection(0);
    }

    private void setSelection(int position){

       FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        hideAllFragments(ft);
        switch (position) {
            case 0:
                if (mhomeLouxiaFragment == null) {
                    mhomeLouxiaFragment = new HomeLouxiaFragment();
                    ft.add(R.id.tab_content,mhomeLouxiaFragment);
                }else {
                    ft.show(mhomeLouxiaFragment);
                }
                break;

            case 1:
                if (mhomeMessageFragment == null) {
                    mhomeMessageFragment = new HomeMessageFragment();
                    ft.add(R.id.tab_content, mhomeMessageFragment);
                }else {
                    ft.show(mhomeMessageFragment);
                }
                break;

            case 2:
                if (mHomeOrderFragment == null) {
                    mHomeOrderFragment = new HomeOrderFragment();
                    ft.add(R.id.tab_content, mHomeOrderFragment);
                }else {
                    ft.show(mHomeOrderFragment);
                }
                break;
            case 3:
                if (mhHomeMineFragment == null) {
                    mhHomeMineFragment = new HomeMineFragment();
                    ft.add(R.id.tab_content, mhHomeMineFragment);
                }else {
                    ft.show(mhHomeMineFragment);
                }
                break;
            default:
                break;
        }
        ft.commit();
    }

    private void hideAllFragments(FragmentTransaction ft){
        if (mhomeLouxiaFragment != null) {
            ft.hide(mhomeLouxiaFragment);
        }

        if (mhomeMessageFragment != null) {
            ft.hide(mhomeMessageFragment);
        }

        if (mHomeOrderFragment != null) {
            ft.hide(mHomeOrderFragment);
        }

        if (mhHomeMineFragment != null) {
            ft.hide(mhHomeMineFragment);
        }
    }



    @Override
    public void onAttachFragment(Fragment fragment) {
        //防止强制退出导致错位的问题
        super.onAttachFragment(fragment);
        if (mhomeLouxiaFragment == null && fragment instanceof HomeLouxiaFragment) {
            mhomeLouxiaFragment = (HomeLouxiaFragment)fragment;
        }else if (mhomeMessageFragment == null && fragment instanceof HomeMessageFragment) {
            mhomeMessageFragment = (HomeMessageFragment)fragment;
        }else if (mHomeOrderFragment == null && fragment instanceof HomeOrderFragment) {
            mHomeOrderFragment = (HomeOrderFragment)fragment;
        }
        else if (mhHomeMineFragment == null && fragment instanceof HomeMineFragment) {
            mhHomeMineFragment = (HomeMineFragment)fragment;
        }
    }

}

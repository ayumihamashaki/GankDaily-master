package com.gudong.gankio.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.gudong.gankio.R;
import com.gudong.gankio.core.FPHelp;
import com.gudong.gankio.data.entity.Store;
import com.gudong.gankio.presenter.StorePresenter;
import com.gudong.gankio.ui.adapter.MyViewPagerAdapter;
import com.gudong.gankio.ui.fragment.StoreInfoFragment;
import com.gudong.gankio.ui.fragment.StoreProductFragment;
import com.gudong.gankio.ui.sharp.CircleTransform;
import com.gudong.gankio.ui.view.IStoreView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class StoreActivity extends BaseActivity<StorePresenter> implements IStoreView {

    @Bind(R.id.tv_store_name)
    TextView tvStoreName;
    @Bind(R.id.tv_store_address)
    TextView tvStoreAddress;
    @Bind(R.id.iv_avatar)
    ImageView ivAvatar;
    private Store store;

    @Override
    protected void initKProgressHUD() {

    }

    @Override
    protected void initPresenter() {
        mPresenter = new StorePresenter(this, this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_store;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ButterKnife.bind(this);
        setTitle(getResources().getString(R.string.action_title_store), true);
        store = (Store) getIntent().getExtras().getSerializable("store");
        if (store != null) {
            setTitle(store.storeName, true);
        }
        init();
    }

    private void init() {
        tvStoreName.setText(store.storeName);
        tvStoreAddress.setText(store.storeAddress);
        Picasso.with(getApplicationContext())
                .load(FPHelp.getInstance().getBaseIMGUrl() + store.storeFacePicture)
                .transform(new CircleTransform())
                .into(ivAvatar);

        // Initialize the Data
        String[] _title = {"商品","商家"};
        List<Fragment> _fragments = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putSerializable("store",store);
        Fragment _StoreProductFragment = new StoreProductFragment();
        Fragment _StoreInfoFragment = new StoreInfoFragment();
        _StoreProductFragment.setArguments(bundle);
        _StoreInfoFragment.setArguments(bundle);
        _fragments.add(_StoreProductFragment);
        _fragments.add(_StoreInfoFragment);

        // Initialize the ViewPager and set an adapter
        ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setAdapter(new myPagerAdapter(getSupportFragmentManager(),_title,_fragments));

        // Bind the tabs to the ViewPager
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(pager);


    }

    @Override
    public void showLoading(boolean isShow) {

    }

    @Override
    public void doSomthing(String msg, int code) {

    }


    class myPagerAdapter extends FragmentPagerAdapter {

        String[] title;
        List<Fragment> fragments;

        public myPagerAdapter(FragmentManager fm, String[] title,List<Fragment> fragments) {
            super(fm);
            this.title = title;
            this.fragments = fragments;
        }


        StoreProductFragment _StoreProductFragment;
        StoreProductFragment fragment2;

        public myPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
           return fragments.get(position);
        }

        @Override
        public int getCount() {

            return title.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }

    }


}

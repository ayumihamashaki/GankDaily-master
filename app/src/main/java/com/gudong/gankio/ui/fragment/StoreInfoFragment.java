package com.gudong.gankio.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gudong.gankio.R;
import com.gudong.gankio.data.entity.Store;
import com.gudong.gankio.presenter.StoreInfoPresenter;
import com.gudong.gankio.presenter.StoreProductPresenter;
import com.gudong.gankio.ui.view.IStoreInfoView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StoreInfoFragment extends BaseFragment<StoreInfoPresenter> implements IStoreInfoView {


    @Bind(R.id.tv_store_opentime)
    TextView tvStoreOpentime;
    @Bind(R.id.tv_store_phone)
    TextView tvStorePhone;
    @Bind(R.id.tv_store_address)
    TextView tvStoreAddress;
    private Store store;

    @Override
    protected void initPresenter() {
        mPresenter = new StoreInfoPresenter(getActivity(),StoreInfoFragment.this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_store_info;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mToolbar.setVisibility(View.GONE);
        store = (Store) getActivity().getIntent().getExtras().getSerializable("store");
        tvStoreOpentime.setText(store.storeOpenTime);
        tvStoreAddress.setText(store.storeAddress);
        tvStorePhone.setText(store.storePhone);
    }

    @Override
    public void showLoading(boolean isShow) {

    }

    @Override
    public void doSomthing(String msg, int code) {

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
}

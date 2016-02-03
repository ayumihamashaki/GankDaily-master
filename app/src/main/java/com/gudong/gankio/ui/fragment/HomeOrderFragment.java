package com.gudong.gankio.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gudong.gankio.R;
import com.gudong.gankio.presenter.HomeOrderFragmentPresenter;
import com.gudong.gankio.ui.activity.StoreActivity;
import com.gudong.gankio.ui.view.IBaseView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by rmtic on 2016/1/20.
 */
public class HomeOrderFragment extends BaseFragment<HomeOrderFragmentPresenter> implements IBaseView {


    @Bind(R.id.button5)
    Button button5;


    @OnClick(R.id.button5)
    public void button5(){
        startActivity(new Intent(getActivity(), StoreActivity.class));
    }

    @Override
    protected void initPresenter() {
        mPresenter = new HomeOrderFragmentPresenter(getActivity(), this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home_order;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mToolbar.setTitle(getString(R.string.action_title_order));
    }

    @Override
    public void showLoading(boolean isShow) {

    }

    @Override
    public void doSomthing(String msg, int code) {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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

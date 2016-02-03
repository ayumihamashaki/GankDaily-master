package com.gudong.gankio.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.gudong.gankio.R;
import com.gudong.gankio.presenter.HomeMessageFragmentPresenter;
import com.gudong.gankio.ui.view.IBaseView;

/**
 * Created by rmtic on 2016/1/20.
 */
public class HomeMessageFragment extends BaseFragment<HomeMessageFragmentPresenter> implements IBaseView {


    @Override
    protected void initPresenter() {
        mPresenter = new HomeMessageFragmentPresenter(getActivity(),this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home_message;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mToolbar.setTitle(getString(R.string.action_title_message));
    }

    @Override
    public void showLoading(boolean isShow) {

    }

    @Override
    public void doSomthing(String msg, int code) {

    }
}

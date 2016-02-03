package com.gudong.gankio.ui.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.activeandroid.query.Select;
import com.gudong.gankio.R;
import com.gudong.gankio.data.entity.User;
import com.gudong.gankio.presenter.HomeLouxiaFragmentPresenter;
import com.gudong.gankio.ui.view.IBaseView;
import com.gudong.gankio.util.DebugUtil;

import java.util.List;

/**
 * Created by rmtic on 2016/1/20.
 */
public class HomeLouxiaFragment extends BaseFragment<HomeLouxiaFragmentPresenter> implements IBaseView {

    @Override
    protected void initPresenter() {
        mPresenter = new HomeLouxiaFragmentPresenter(getActivity(),this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home_louxia;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mToolbar.setTitle(getString(R.string.action_title_louxia));

    }

    @Override
    public void showLoading(boolean isShow) {

    }

    @Override
    public void doSomthing(String msg, int code) {

    }
}

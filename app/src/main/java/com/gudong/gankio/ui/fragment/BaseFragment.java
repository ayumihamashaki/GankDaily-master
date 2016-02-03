package com.gudong.gankio.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;

import com.gudong.gankio.R;
import com.gudong.gankio.presenter.BasePresenter;
import android.support.v7.app.AppCompatActivity;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by rmtic on 2016/1/20.
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment{

    @Bind(R.id.toolbar)
    protected Toolbar mToolbar;

    protected P mPresenter;

    protected abstract void initPresenter();
    protected abstract int getLayout();

    private void checkPresenterIsNull(){
        if(mPresenter == null){
            throw new IllegalStateException("please init mPresenter in initPresenter() method ");
        }

    }

    final private void initToolBar() {
        if(mToolbar == null){
            throw new NullPointerException("please add a Toolbar in your layout.");
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(getLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initPresenter();
       // checkPresenterIsNull();
       // initToolBar();
    }


}

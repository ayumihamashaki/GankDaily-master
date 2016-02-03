package com.gudong.gankio.presenter;

import android.app.Activity;

import com.gudong.gankio.ui.view.IBaseView;
import com.gudong.gankio.ui.view.IStoreProductView;

/**
 * Created by rmtic on 2016/1/19.
 */
public class StoreProductPresenter extends BasePresenter<IStoreProductView> {

    public StoreProductPresenter(Activity context, IStoreProductView view) {
        super(context, view);
    }



}

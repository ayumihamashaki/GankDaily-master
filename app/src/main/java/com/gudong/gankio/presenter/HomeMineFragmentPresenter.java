package com.gudong.gankio.presenter;

import android.app.Activity;

import com.gudong.gankio.core.FPHelp;
import com.gudong.gankio.ui.view.IBaseView;
import com.gudong.gankio.ui.view.IMineView;

/**
 * Created by rmtic on 2016/1/19.
 */
public class HomeMineFragmentPresenter extends BasePresenter<IMineView> {

    public HomeMineFragmentPresenter(Activity context, IMineView view) {
        super(context, view);
    }

    public void refresh(){
        if(FPHelp.getInstance().getCurrentUser()!=null){
            mView.onLine();
        }else{
            mView.offLine();
        }
    }

}

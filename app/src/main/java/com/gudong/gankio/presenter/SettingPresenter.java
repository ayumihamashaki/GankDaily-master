package com.gudong.gankio.presenter;

import android.app.Activity;

import com.gudong.gankio.core.FPHelp;
import com.gudong.gankio.ui.view.IBaseView;

import rx.Observable;

/**
 * Created by rmtic on 2016/1/19.
 */
public class SettingPresenter extends BasePresenter<IBaseView> {

    public SettingPresenter(Activity context, IBaseView view) {
        super(context, view);
    }

    /**
     * 退出当前账户
     */
   public void logout(){
        if(!FPHelp.getInstance().isLogin()){
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                mView.showLoading(true);
            }
        });
        FPHelp.getInstance().logOut();
        mView.showLoading(false);
        mView.doSomthing("成功退出", 4);
        FPHelp.getInstance().refreshUserUI();
    }

}

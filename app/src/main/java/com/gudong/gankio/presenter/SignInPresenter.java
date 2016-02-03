package com.gudong.gankio.presenter;

import android.app.Activity;

import com.gudong.gankio.core.FPHelp;
import com.gudong.gankio.data.UserData;
import com.gudong.gankio.data.entity.User;
import com.gudong.gankio.ui.view.IBaseView;
import com.gudong.gankio.ui.view.ISignInView;
import com.gudong.gankio.util.DebugUtil;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by rmtic on 2016/1/19.
 */
public class SignInPresenter extends BasePresenter<ISignInView> {

    public SignInPresenter(Activity context, ISignInView view) {
        super(context, view);
    }

    public void signin(final User user){

        mFP.signin(user.cellphone.toString(), user.password.toString())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<UserData>() {

                    @Override
                    public void onStart() {
                        super.onStart();
                        mView.showLoading(true);
                    }

                    @Override
                    public void onCompleted() {
                        mView.showLoading(false);
                        DebugUtil.i("完成");
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showLoading(false);
                        mView.doSomthing("请求失败",-2);
                        DebugUtil.i("错误:"+e.getMessage());
                    }

                    @Override
                    public void onNext(UserData userData) {
                        if (userData != null && userData.errorCode.equals("1001")) {
                            User user = userData.data;
                            FPHelp.getInstance().setCurrentUser(user);
                            FPHelp.refreshUserUI();
                        }
                        mView.doSomthing(userData.msg, Integer.parseInt(userData.errorCode));
                    }
                });
    }

}

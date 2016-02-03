package com.gudong.gankio.presenter;

import android.app.Activity;

import com.gudong.gankio.core.FPHelp;
import com.gudong.gankio.data.FeedBackData;
import com.gudong.gankio.data.QiNiuTokenData;
import com.gudong.gankio.ui.view.IBaseView;
import com.gudong.gankio.ui.view.IStoreSignInView;
import com.gudong.gankio.util.DebugUtil;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by rmtic on 2016/1/27.
 */
public class StoreSignInPresenter extends BasePresenter<IStoreSignInView> {


    public static QiNiuTokenData mToken;

    public StoreSignInPresenter(Activity context, IStoreSignInView view) {
        super(context, view);
    }

    /**
     * 获取上传凭证
     */
    public void getQiNiuToken(){
        if(mToken!=null){
            mView.onTokenLoaded(mToken);
            return;
        }
        mFP.getQiNiuToken()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<QiNiuTokenData>() {
                    @Override
                    public void onCompleted() {
                        DebugUtil.i("QiNiuToken:完成");
                    }

                    @Override
                    public void onError(Throwable e) {
                        DebugUtil.i("QiNiuToken:失败" + e.getMessage());
                    }

                    @Override
                    public void onNext(QiNiuTokenData result) {
                        mToken = result;
                        mView.onTokenLoaded(result);
                    }
        });
    }


}

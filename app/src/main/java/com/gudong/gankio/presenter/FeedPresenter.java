package com.gudong.gankio.presenter;

import android.app.Activity;
import android.text.TextUtils;

import com.gudong.gankio.data.FeedBackData;
import com.gudong.gankio.data.UserData;
import com.gudong.gankio.ui.view.IBaseView;
import com.gudong.gankio.ui.view.IFeedBackView;
import com.gudong.gankio.util.DebugUtil;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by rmtic on 2016/1/19.
 */
public class FeedPresenter  extends BasePresenter<IBaseView> {

    public FeedPresenter(Activity context, IBaseView view) {
        super(context, view);
    }

    /**
     * To save FeedBack
     */
    public void saveFeedBack(String phone,String content){
        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(content)) {return;}
        mFP.saveFeedback(phone,content)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<FeedBackData>() {

                    @Override
                    public void onStart() {
                        super.onStart();
                        mView.showLoading(true);
                    }

                    @Override
                    public void onCompleted() {
                        mView.showLoading(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showLoading(false);
                    }

                    @Override
                    public void onNext(FeedBackData feedBackData) {
                        mView.doSomthing(feedBackData.msg, Integer.parseInt(feedBackData.errorCode));
                    }
                });
    }

}

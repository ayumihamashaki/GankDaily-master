package com.gudong.gankio.presenter;

import android.app.Activity;

import com.gudong.gankio.core.FPHelp;
import com.gudong.gankio.data.CollectData;
import com.gudong.gankio.data.entity.Collect;
import com.gudong.gankio.data.entity.User;
import com.gudong.gankio.ui.view.IBaseView;
import com.gudong.gankio.ui.view.ICollectMangerView;
import com.gudong.gankio.util.DebugUtil;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by rmtic on 2016/1/19.
 */
public class CollectMangerPresenter extends BasePresenter<ICollectMangerView> {

    public CollectMangerPresenter(Activity context, ICollectMangerView view) {
        super(context, view);
    }

    public void getData(){
        if(!FPHelp.getInstance().isLogin()){
            return;
        }
        User user = FPHelp.getInstance().getCurrentUser();
        mFP.getCollectStores(user.id+"")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<CollectData>() {

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
                    public void onNext(CollectData collectData) {
                        mView.onDataLoad(collectData);
                    }
                });
    }

}

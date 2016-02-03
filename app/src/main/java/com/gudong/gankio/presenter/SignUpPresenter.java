package com.gudong.gankio.presenter;

import android.app.Activity;
import android.util.DebugUtils;

import com.gudong.gankio.core.FP;
import com.gudong.gankio.core.MainFactory;
import com.gudong.gankio.data.UserData;
import com.gudong.gankio.data.entity.Res;
import com.gudong.gankio.data.entity.User;
import com.gudong.gankio.ui.view.IBaseView;
import com.gudong.gankio.util.DateUtil;
import com.gudong.gankio.util.DebugUtil;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by rmtic on 2016/1/19.
 */
public class SignUpPresenter extends BasePresenter<IBaseView> {

    public SignUpPresenter(Activity context, IBaseView view) {
        super(context, view);
    }


}

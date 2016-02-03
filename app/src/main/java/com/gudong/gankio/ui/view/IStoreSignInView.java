package com.gudong.gankio.ui.view;

import com.gudong.gankio.data.QiNiuTokenData;

/**
 * Created by rmtic on 2016/1/27.
 */
public interface IStoreSignInView extends  IBaseView{

    void onTokenLoaded(QiNiuTokenData result);

}

package com.gudong.gankio.ui.view;

/**
 * Created by rmtic on 2016/1/19.
 */
public interface IFeedBackView extends IBaseView{
    void saveSuccess(String message);
    void showFailInfo(String error);
}

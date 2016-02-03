package com.gudong.gankio.core;

import com.gudong.gankio.data.CollectData;
import com.gudong.gankio.data.FeedBackData;
import com.gudong.gankio.data.QiNiuTokenData;
import com.gudong.gankio.data.UserData;
import com.gudong.gankio.data.entity.Collect;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by rmtic on 2016/1/21.
 */
public interface FP {

    //获取七牛token
    @GET("/usersAction!getUpToken")
    public Observable<QiNiuTokenData> getQiNiuToken();

    //登陆
    @FormUrlEncoded
    @POST("/usersAction!Logins")
    public Observable<UserData> signin(@Field("cellphone") String cellphone, @Field("password") String password);

    //添加,意见反馈
    @FormUrlEncoded
    @POST("/suggestionAction!SuggestionSave")
    public Observable<FeedBackData> saveFeedback(@Field("phone") String phone, @Field("content") String content);

    //获取用户收藏的所有店铺
    @FormUrlEncoded
    @POST("/collectsAction!findAllCollects")
    public Observable<CollectData> getCollectStores(@Field("uid") String uid);



}

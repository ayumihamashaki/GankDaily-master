package com.gudong.gankio.presenter;

import android.app.Activity;
import android.content.Context;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.google.gson.Gson;
import com.gudong.gankio.data.QiNiuTokenData;
import com.gudong.gankio.ui.view.ISearchVillageView;
import com.gudong.gankio.ui.view.IStoreSignInView;
import com.gudong.gankio.util.DebugUtil;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by rmtic on 2016/1/27.
 */
public class SearchVillagePresenter extends BasePresenter<ISearchVillageView> {

    //百度POI检索
    private PoiSearch mPoiSearch;
    private OnGetPoiSearchResultListener poiListener = new OnGetPoiSearchResultListener(){
        public void onGetPoiResult(PoiResult result){
            mView.onVillageLoaded(result.getAllPoi());
        }
        public void onGetPoiDetailResult(PoiDetailResult result){
            //获取Place详情页检索结果
        }
    };

    public SearchVillagePresenter(Activity context, ISearchVillageView view) {
        super(context, view);
    }

    /**
     * 获取小区数据
     * @param _keyword
     */
    public void getPoiResult(LatLng _latLng,String _keyword){
        mPoiSearch = PoiSearch.newInstance();
        mPoiSearch.setOnGetPoiSearchResultListener(poiListener);
        mPoiSearch.searchNearby(new PoiNearbySearchOption()
                .location(_latLng)
                .keyword(_keyword)
                .radius(50000));
    }









}

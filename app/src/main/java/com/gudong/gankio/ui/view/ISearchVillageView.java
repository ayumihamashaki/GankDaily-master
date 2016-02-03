package com.gudong.gankio.ui.view;

import com.baidu.mapapi.search.core.PoiInfo;
import com.gudong.gankio.data.QiNiuTokenData;

import java.util.List;

/**
 * Created by rmtic on 2016/1/27.
 */
public interface ISearchVillageView extends  IBaseView{


    public void onVillageLoaded(List<PoiInfo> poiInfos);

}

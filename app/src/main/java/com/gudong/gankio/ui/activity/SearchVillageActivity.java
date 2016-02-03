package com.gudong.gankio.ui.activity;

import android.os.Bundle;
import android.widget.ListView;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.gudong.gankio.R;
import com.gudong.gankio.core.PreferenceManager;
import com.gudong.gankio.presenter.SearchVillagePresenter;
import com.gudong.gankio.ui.adapter.base.CommonAdapter;
import com.gudong.gankio.ui.adapter.base.ViewHolder;
import com.gudong.gankio.ui.view.ISearchVillageView;

import java.util.List;

import butterknife.Bind;

/**
 * 选择检索小区
 */
public class SearchVillageActivity extends BaseActivity<SearchVillagePresenter> implements ISearchVillageView {

    @Bind(R.id.lv_poiinfo)
    ListView lvPoiinfo;
    private String _city;
    private String _keyword;

    @Override
    protected void initKProgressHUD() {

    }

    @Override
    protected void initPresenter() {
        mPresenter = new SearchVillagePresenter(this, this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_search_village;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getResources().getString(R.string.action_title_search_village), true);


        _city = PreferenceManager.getInstance().getBDLocation().getCity();
        Double _lat = PreferenceManager.getInstance().getBDLocation().getLatitude();
        Double _lng = PreferenceManager.getInstance().getBDLocation().getLongitude();
        LatLng _LatLng = new LatLng(_lat, _lng);
        _keyword = "小区";
        mPresenter.getPoiResult(_LatLng, _keyword);


    }


    @Override
    public void showLoading(boolean isShow) {

    }

    @Override
    public void doSomthing(String msg, int code) {

    }

    @Override
    public void onVillageLoaded(List<PoiInfo> poiInfos) {
        CommonAdapter commonAdapter = new CommonAdapter<PoiInfo>(
                getApplicationContext(),
                poiInfos,
                R.layout.row_poiinfo) {

            @Override
            public void convert(ViewHolder holder, PoiInfo poiInfo) {
                if (poiInfo == null) {
                    return;
                }
                holder.setText(R.id.tv_poiInfo_name, poiInfo.name);
                holder.setText(R.id.tv_poiInfo_address, poiInfo.address);
            }
        };
        lvPoiinfo.setAdapter(commonAdapter);
    }
}

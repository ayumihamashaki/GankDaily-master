package com.gudong.gankio.core;

import android.content.Context;
import android.content.SharedPreferences;

import com.baidu.location.BDLocation;
import com.baidu.mapapi.search.poi.PoiResult;
import com.google.gson.Gson;

/**
 * Created by rmtic on 2016/1/22.
 */
public class PreferenceManager {

    public static final String PREFERENCE_NAME = "saveInfo";
    private static SharedPreferences mSharedPreferences;
    private static PreferenceManager mPreferencemManager;
    private static SharedPreferences.Editor editor;

    private static String APP_KEY_IS_FIRST_RUN = "KEY_IS_FIRST_RUN";
    private static String APP_KEY_CUR_USER = "APP_KEY_CUR_USER";
    private static String APP_KEY_BDLOCATION = "APP_KEY_BDLOCATION";


    //帐户
    //设置
    private PreferenceManager(Context cxt) {
        mSharedPreferences = cxt.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
    }

    public static synchronized void init(Context cxt){
        if(mPreferencemManager == null){
            mPreferencemManager = new PreferenceManager(cxt);
        }
    }

    public synchronized static PreferenceManager getInstance() {
        if (mPreferencemManager == null) {
            throw new RuntimeException("请先初始化PreferenceManager,例如:PreferenceManager.init(this);");
        }
        return mPreferencemManager;
    }

    /**
     * 设置是否为第一次运行
     * @param isfirst
     */
    public void setIsFirstRun(boolean isfirst){
        editor.putBoolean(APP_KEY_IS_FIRST_RUN, isfirst);
        editor.commit();
    }

    /**
     * 获取是否为第一次运行
     */
    public boolean isFirstRun(){
        return mSharedPreferences.getBoolean(APP_KEY_IS_FIRST_RUN,true);
    }


    /**
     * 设置当前用户
     * @param json
     */
    public void setCurrentUser(String json){
        editor.putString(APP_KEY_CUR_USER,json);
        editor.commit();
    }

    /**
     * 获取是否为第一次运行
     */
    public String getCurrentUser(){
        return  mSharedPreferences.getString(APP_KEY_CUR_USER,"");//值默认为“”
    }


    /**
     * 设置本地的PoiResult对象
     * @param _BDLocation
     */
   public void setBDLocation(BDLocation _BDLocation){
        if(_BDLocation==null){return;}
        Gson gson = new Gson();
        String json = gson.toJson(_BDLocation);
        editor.putString(APP_KEY_BDLOCATION,json);
        editor.commit();
   }

    /**
     * 获取本地的PoiResult对象
     * @return
     */
    public BDLocation getBDLocation(){
        BDLocation _BDLocation = null;
        String json = mSharedPreferences.getString(APP_KEY_BDLOCATION,"");
        if(!json.equals("")){
            Gson gson = new Gson();
            _BDLocation = gson.fromJson(json,BDLocation.class);
        }
        return _BDLocation;
    }
}

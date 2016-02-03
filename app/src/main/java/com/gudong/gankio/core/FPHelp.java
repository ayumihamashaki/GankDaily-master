package com.gudong.gankio.core;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import com.activeandroid.ActiveAndroid;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.google.gson.Gson;
import com.gudong.gankio.BuildConfig;
import com.gudong.gankio.GankApp;
import com.gudong.gankio.data.UserData;
import com.gudong.gankio.data.entity.User;
import com.gudong.gankio.ui.activity.HomeActivity;
import com.gudong.gankio.ui.activity.SignInActivity;
import com.gudong.gankio.ui.event.RxBus;
import com.gudong.gankio.ui.event.UserEvent;
import com.gudong.gankio.ui.widget.PicassoImageLoader;
import com.gudong.gankio.util.DebugUtil;
import com.gudong.gankio.util.ToastUtils;

import java.util.Timer;
import java.util.TimerTask;

import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ImageLoader;
import cn.finalteam.galleryfinal.ThemeConfig;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by rmtic on 2016/1/22.
 */
public class FPHelp {

    private Context context;
    private static FPHelp instance = null;

    //百度地图定位
    public static LocationClient mLocationClient = null;
    public static BDLocationListener myListener = new MyLocationListener();
    public static class MyLocationListener implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            PreferenceManager.getInstance().setBDLocation(location);
            mLocationClient.stop();
        }
    }

    private FPHelp(Context context) {
        this.context = context;
    }

    public static synchronized void init(Context context){
        if(instance==null){
            instance = new FPHelp(context);
        }
        ActiveAndroid.initialize(context);//初始化数据库
        PreferenceManager.init(context);//初始化Preference
        //初始化百度地图
        if (!"generic".equalsIgnoreCase(Build.BRAND)) {
            SDKInitializer.initialize(context);
            DebugUtil.i("百度地图初始化");
        }
        doDBLocation(context,myListener);
        //初始化相册
        ThemeConfig theme = new ThemeConfig.Builder()
                .setTitleBarBgColor(Color.rgb(224, 0, 50))
                .build();
        FunctionConfig functionConfig = new FunctionConfig.Builder()
                .setEnableCamera(true)
                .setEnableEdit(true)
                .setEnableCrop(true)
                .setEnableRotate(true)
                .setCropSquare(true)
                .setEnablePreview(true)
                .setForceCrop(true)
                .build();
        ImageLoader imageloader = new PicassoImageLoader();
        CoreConfig coreConfig = new CoreConfig.Builder(context, imageloader,theme)
                .setDebug(BuildConfig.DEBUG)
                .setFunctionConfig(functionConfig)
                .build();
        GalleryFinal.init(coreConfig);

    }


    public static void doDBLocation(Context context,BDLocationListener myListener){
        //定位
        mLocationClient = new LocationClient(context);     //声明LocationClient类
        mLocationClient.registerLocationListener( myListener );    //注册监听函数
        initLocation();
        mLocationClient.start();
    }

    public static void initLocation(){
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Battery_Saving);//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span=1000;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }


    /**
     * 初次要做的事情,
     * 1.判断是否第一次运行，【是】跳转到引导界面，【不是】条转到主界面
     * 2.判断本地是否存在已经登录的帐号 ，【是】判断用户是否过期，【不是】跳转到登录界面
     * 3.判断用户登录状态是否过期，【是】跳转到登录界面 【不是】自动登录
     * 4.刷新用户数据，重新初始化
     */
    public void doFirst(Context context){

        //步骤 1：
        if(PreferenceManager.getInstance().isFirstRun()){
            //ToastUtils.showLong("第一次运行");
            PreferenceManager.getInstance().setIsFirstRun(false);
            //context.startActivity(new Intent(context, GuideActivity.class));
            context.startActivity(new Intent(context,HomeActivity.class));
        }else{
            //ToastUtils.showLong("不是第一次运行");
            context.startActivity(new Intent(context, HomeActivity.class));
        }
        //步骤 2：
        if(getCurrentUser()==null){
            context.startActivity(new Intent(context,SignInActivity.class));
        }
        //步骤 3：
        /*if(getCurrentUser()!=null && !getCurrentUser().createdAt.equals("")){

        }*/
        //步骤 4：



    }

    /**
     * 返回七牛的图片地址
     * @return
     */
    public String getBaseIMGUrl(){
        String url = "http://7xlltk.com1.z0.glb.clouddn.com/";
        return url;
    }

    /**
     * 返回一个实例
     * @return
     */
    public synchronized static FPHelp getInstance() {
        if (instance == null) {
            throw new RuntimeException("请初始化FPHelp");
        }
        return instance;
    }

    public boolean isLogin(){
        return getCurrentUser()!=null;
    }

    /**
     * 获取当前账户
     * @return
     */
    public User getCurrentUser(){
        try {
            if(!PreferenceManager.getInstance().getCurrentUser().equals("")){
                Gson gson =new Gson();
                User user = gson.fromJson(PreferenceManager.getInstance().getCurrentUser(), User.class);
                if(user!=null){
                    return user;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 设置当前账户
     * @param user
     */
    public void setCurrentUser(User user){
        try {
            if(user!=null){
                Gson gson = new Gson();
                String json = gson.toJson(user);
                PreferenceManager.getInstance().setCurrentUser(json);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 退出账户
     */
    public void logOut(){
        if(isLogin()){
            PreferenceManager.getInstance().setCurrentUser("");
        }
    }

    /**
     * 刷新APP用户UI
     */
    public static void refreshUserUI(){
        DebugUtil.i("发送1");
        RxBus _RxBus = RxBus.getInstance();
        if (_RxBus.hasObservers()) {
            DebugUtil.i("发送2");
            _RxBus.send(new UserEvent());
        }
    }



}

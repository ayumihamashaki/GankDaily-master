/*
 *
 * Copyright (C) 2015 Drakeet <drakeet.me@gmail.com>
 * Copyright (C) 2015 GuDong <maoruibin9035@gmail.com>
 *
 * Meizhi is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Meizhi is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Meizhi.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.gudong.gankio;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.activeandroid.ActiveAndroid;
import com.baidu.mapapi.SDKInitializer;
import com.gudong.gankio.core.FPHelp;
import com.gudong.gankio.core.PreferenceManager;
import com.gudong.gankio.data.entity.User;
import com.gudong.gankio.ui.activity.HomeActivity;
import com.gudong.gankio.ui.adapter.base.ViewHolder;
import com.gudong.gankio.util.DebugUtil;
import com.gudong.gankio.util.ToastUtils;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by GuDong on 10/14/15 23:42.
 * Contact with 1252768410@qq.com.
 */
public class GankApp extends Application {
    public static Context sContext;
    @Override
    public void onCreate() {
        super.onCreate();

        sContext = this;
        //只有调试模式下 才启用日志输出
        if(BuildConfig.DEBUG){
            Logger.init("Gank").hideThreadInfo().setMethodCount(0);
        }else{
            Logger.init("Gank").setLogLevel(LogLevel.NONE);
        }
        FPHelp.init(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ActiveAndroid.dispose();
    }
}

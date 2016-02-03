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

package com.gudong.gankio.core;
/**
 * Created by GuDong on 15/10/8.
 * Contact with 1252768410@qq.com
 */
public class MainFactory {
    /**
     * 数据主机地址
     */
    public static final String HOST = "http://120.24.81.143:8080/LouXiaAppSysytem";

    private static FP mFP;

    protected static final Object monitor = new Object();

    public static FP getFPInstance(){
        synchronized (monitor){
            if(mFP==null){
                mFP = new MainRetrofit().getService();
            }
            return mFP;
        }
    }
}

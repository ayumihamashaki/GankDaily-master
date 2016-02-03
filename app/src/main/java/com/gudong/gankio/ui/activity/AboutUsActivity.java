package com.gudong.gankio.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.gudong.gankio.BuildConfig;
import com.gudong.gankio.R;
import com.gudong.gankio.presenter.AboutUsPresenter;
import com.gudong.gankio.ui.view.IBaseView;
import com.gudong.gankio.ui.widget.PicassoImageLoader;
import com.gudong.gankio.util.AddressUtil;
import com.gudong.gankio.util.DebugUtil;
import com.squareup.okhttp.internal.Internal;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ImageLoader;
import cn.finalteam.galleryfinal.ThemeConfig;
import cn.finalteam.galleryfinal.model.PhotoInfo;

public class AboutUsActivity  extends BaseActivity<AboutUsPresenter> implements IBaseView {

    @Bind(R.id.wb)WebView wb;
    String html = "<p>\n" +
            "    <span style=\"font-size: 14px; color: rgb(89, 89, 89);\">&quot;飞铺&quot;是由深圳市紫瑞天成网络科技有限公司开发的一款社区购物APP。<br/><br/></span>\n" +
            "</p>\n" +
            "<p>\n" +
            "    <span style=\"font-size: 14px; color: rgb(89, 89, 89);\">我们的目标是让中国成千上万社区的千万家实体店面上线，与小区业主和顾客实现零成本的实时沟通，提升中国人社区购物的便利性。<br/><br/></span>\n" +
            "</p>\n" +
            "<p>\n" +
            "    <span style=\"font-size: 14px; color: rgb(89, 89, 89);\">为了生活购物更便利，我们出发了！</span>\n" +
            "</p>";

    @Override
    protected void initKProgressHUD() {

    }

    @Override
    protected void initPresenter() {
        mPresenter = new AboutUsPresenter(this,this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_about_us;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getResources().getString(R.string.action_title_aboutus), true);
        //加载网页数据
        wb.loadDataWithBaseURL(null, html, "text/html", "utf-8", null);
        WebSettings webSettings= wb.getSettings();
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    }

    @Override
    public void showLoading(boolean isShow) {

    }

    @Override
    public void doSomthing(String msg, int code) {

    }
}

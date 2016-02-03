package com.gudong.gankio.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gudong.gankio.R;
import com.gudong.gankio.core.FP;
import com.gudong.gankio.core.FPHelp;
import com.gudong.gankio.core.MainFactory;
import com.gudong.gankio.data.UserData;
import com.gudong.gankio.data.entity.User;
import com.gudong.gankio.presenter.SignInPresenter;
import com.gudong.gankio.presenter.SignUpPresenter;
import com.gudong.gankio.ui.view.ISignInView;
import com.gudong.gankio.util.DebugUtil;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * 欢迎界面
 */
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //延迟运行
       new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(WelcomeActivity.this,HomeActivity.class));
                finish();
            }
        }, 3000);
    }

}

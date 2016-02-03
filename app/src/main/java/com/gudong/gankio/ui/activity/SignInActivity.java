package com.gudong.gankio.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gudong.gankio.R;
import com.gudong.gankio.data.entity.User;
import com.gudong.gankio.presenter.SignInPresenter;
import com.gudong.gankio.ui.event.RxBus;
import com.gudong.gankio.ui.view.ISignInView;
import com.gudong.gankio.util.DebugUtil;
import com.gudong.gankio.util.ToastUtils;
import com.kaopiz.kprogresshud.KProgressHUD;

import butterknife.Bind;
import butterknife.OnClick;
import me.drakeet.materialdialog.MaterialDialog;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

public class SignInActivity  extends BaseActivity<SignInPresenter> implements ISignInView {
    public static class TapEvent extends RxBus.BusEvent{}
    @Bind(R.id.et_account)
    EditText etAccount;
    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.bt_sign_in)
    Button btSignIn;
    @Bind(R.id.bt_find_password)
    Button btFindPassword;
    @Bind(R.id.bt_sign_up)
    Button btSignUp;


    @OnClick(R.id.bt_find_password)
    public void btFindPassword(){
        startActivity(new Intent(this,UserFindPWDActivity.class));
    }

    @OnClick(R.id.bt_sign_up)
    public void btSignUp(){
        startActivity(new Intent(this,SignUpActivity.class));
    }

    @OnClick(R.id.bt_sign_in)
    public void btSignIn(){
        String account = etAccount.getText().toString();
        String password = etPassword.getText().toString();
        if(TextUtils.isEmpty(account)){
            doSomthing("帐户不能为空!",-2);
            return;
        }
        if(TextUtils.isEmpty(password)){
            doSomthing("密码不能为空!",-2);
            return;
        }
        User user = new User(account,password);
        mPresenter.signin(user);
    }

    @Override
    protected void initKProgressHUD() {
        mKProgressHUD = KProgressHUD.create(this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("请等待")
                .setDetailsLabel("正在加载数据...");
    }

    @Override
    protected void initPresenter() {
        mPresenter = new SignInPresenter(this, this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_sign_in;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.action_title_signin), true);
    }


    MaterialDialog mMaterialDialog;
    @Override
    public void doSomthing(String msg, int code) {

        switch (code){
            case -2:
                if(mMaterialDialog==null){
                    mMaterialDialog = new MaterialDialog(this);
                }
                mMaterialDialog
                        .setTitle("温馨提示")
                        .setMessage(msg)
                        .setPositiveButton("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mMaterialDialog.dismiss();
                            }
                        });
                mMaterialDialog.show();
                break;
            case 1001:
                if(mMaterialDialog==null){
                    mMaterialDialog = new MaterialDialog(this);
                }
                mMaterialDialog
                        .setTitle("温馨提示")
                        .setMessage(msg)
                        .setPositiveButton("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                SignInActivity.this.finish();
                                mMaterialDialog.dismiss();
                            }
                        });
                mMaterialDialog.show();
                break;
            case 1002:
                if(mMaterialDialog==null){
                    mMaterialDialog = new MaterialDialog(this);
                }
                mMaterialDialog
                        .setTitle("温馨提示")
                        .setMessage(msg)
                        .setPositiveButton("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mMaterialDialog.dismiss();
                            }
                        });
                mMaterialDialog.show();
                break;
            default:
                break;
        }
    }

    @Override
    public void showLoading(boolean isShow) {
        if (mKProgressHUD == null) {
            throw new RuntimeException("请先初始化mKProgressHUD;");
        }
        if(isShow){
            mKProgressHUD.show();
        }else{
            mKProgressHUD.dismiss();
        }
    }
}

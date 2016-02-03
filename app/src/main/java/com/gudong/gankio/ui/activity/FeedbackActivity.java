package com.gudong.gankio.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gudong.gankio.R;
import com.gudong.gankio.presenter.FeedPresenter;
import com.gudong.gankio.ui.view.IBaseView;
import com.kaopiz.kprogresshud.KProgressHUD;

import butterknife.Bind;
import butterknife.OnClick;
import me.drakeet.materialdialog.MaterialDialog;

public class FeedbackActivity extends BaseActivity<FeedPresenter> implements IBaseView {

    MaterialDialog mMaterialDialog;
    @Bind(R.id.et_content)
    EditText etContent;
    @Bind(R.id.et_phone)
    EditText etPhone;
    @Bind(R.id.bt_confirm)
    Button btConfirm;

    @OnClick(R.id.bt_confirm)
    public void btConfirm(){
        String content = etContent.getText().toString();
        String phone = etPhone.getText().toString();
        if(TextUtils.isEmpty(content)){
            doSomthing("请填写建议!",-2);
            return;
        }
        if(TextUtils.isEmpty(phone)){
            doSomthing("请填写电话!",-2);
            return;
        }
        mPresenter.saveFeedBack(phone,content);
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
        mPresenter = new FeedPresenter(this, this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_feedback;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getResources().getString(R.string.action_title_feedback), true);
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
                                mMaterialDialog.dismiss();
                                finish();
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
}

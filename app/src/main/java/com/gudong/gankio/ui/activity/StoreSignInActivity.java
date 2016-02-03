package com.gudong.gankio.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gudong.gankio.R;
import com.gudong.gankio.core.FPHelp;
import com.gudong.gankio.data.QiNiuTokenData;
import com.gudong.gankio.data.entity.Store;
import com.gudong.gankio.presenter.StoreSignInPresenter;
import com.gudong.gankio.ui.view.IStoreSignInView;
import com.gudong.gankio.util.DebugUtil;
import com.gudong.gankio.util.ToastUtils;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UploadManager;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.List;
import butterknife.Bind;
import butterknife.OnClick;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.model.PhotoInfo;
import de.hdodenhof.circleimageview.CircleImageView;

public class StoreSignInActivity extends BaseActivity<StoreSignInPresenter> implements IStoreSignInView {

    @Bind(R.id.btn_post)Button btn_post;
    @OnClick(R.id.btn_post)
    public void btnPost(){
        DebugUtil.i(store.toString());
        if(store.storeName==null){ToastUtils.showLong("店铺名称不能为空!");return;}//店铺名称
        if(store.storeAddress==null){ToastUtils.showLong("店铺地址不能为空!");return;}//店铺地址
        if(store.storePhone==null){ToastUtils.showLong("联系电话不能为空!");return;}//联系电话
        if(store.storeDesc==null){ToastUtils.showLong("店铺描述不能为空!");return;}//店铺描述
        if(store.storeLatitude==0.0){ToastUtils.showLong("经纬度不能为空!");return;}//营业执照编号
        if(store.storeLongitude==0.0){ToastUtils.showLong("经纬度不能为空!");return;}//营业执照编号
        if(store.storeFacePicture==null){ToastUtils.showLong("店铺图标不能为空!");return;}//店铺图标
        if(store.licenseId==null){ToastUtils.showLong("营业执照编号不能为空!");return;}//营业执照编号
        if(store.identityCard==null){ToastUtils.showLong("身份证不能为空!");return;}//身份证
        if(store.identityCardPicture==null){ToastUtils.showLong("手持身份证不能为空!");return;}//手持身份证
        if(store.logoPicture==null){ToastUtils.showLong("营业编号不能为空!");return;}//营业编号
        if(store.villageId==null){ToastUtils.showLong("所在小区不能为空!");return;}//小区编号
        if(store.villageName==null){ToastUtils.showLong("所在小区不能为空!");return;}//小区名称
        if(store.villageAddress==null){ToastUtils.showLong("所在小区不能为空!");return;}//小区地址
    }



    @Bind(R.id.ly_village)
    LinearLayout ly_village;

    @OnClick(R.id.ly_village)
    public void LyVillage(){
        startActivityForResult(new Intent(this,SearchVillageActivity.class),1);
    }

    @Bind(R.id.iv_store_face)
    CircleImageView ivStoreFace;

    @Bind(R.id.iv_idcard)
    ImageView ivIdcard;

    @Bind(R.id.ivStoreHandIdCard)
    ImageView ivStoreHandIdCard;


    @Bind(R.id.ivStoreBussinessCard)
    ImageView ivStoreBussinessCard;


    @Bind(R.id.et_store_name) EditText etStoreName;
    @Bind(R.id.et_store_address) EditText etStoreAddress;
    @Bind(R.id.et_store_phone) EditText etStorePhone;
    @Bind(R.id.et_store_describe) EditText etStoreDesc;
    @Bind(R.id.et_store_bussiness_num) EditText etStoreLicenseId;

    private Store store;
    @Override
    protected void initPresenter() {
        mPresenter = new StoreSignInPresenter(this, this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_store_sign_in;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getResources().getString(R.string.action_title_store_sign_in), true);
        store = new Store();
        //获取Token
        mPresenter.getQiNiuToken();
        //绑定数据
        BindData();
    }

    public void BindData(){
        //店铺名称
        etStoreName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(store!=null){
                    store.storeName = etStoreName.getText().toString();
                }
            }
        });
        //店铺地址
        etStoreAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(store!=null){
                    store.storeAddress = etStoreAddress.getText().toString();
                }
            }
        });
        //联系电话
        etStorePhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(store!=null){
                    store.storePhone = etStorePhone.getText().toString();
                }
            }
        });
        //店铺描述
        etStoreDesc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(store!=null){
                    store.storeDesc = etStoreDesc.getText().toString();
                }
            }
        });
        //营业编号
        etStoreLicenseId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(store!=null){
                    store.licenseId = etStoreLicenseId.getText().toString();
                }
            }
        });
    }


    @OnClick(R.id.ivStoreHandIdCard)
    public void ivStoreHandIdCard(){
        if(mPresenter.mToken!=null){
            DebugUtil.i(mPresenter.mToken.data);
        }
        GalleryFinal.openGallerySingle(1, new GalleryFinal.OnHanlderResultCallback() {
            @Override
            public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {


                UploadManager uploadManager = new UploadManager();
                String data = resultList.get(0).getPhotoPath();
                String key = null;
                String token = mPresenter.mToken.data;
                uploadManager.put(data, key, token,
                        new UpCompletionHandler() {
                            @Override
                            public void complete(String key, ResponseInfo info,JSONObject res) {
                                //  res 包含hash、key等信息，具体字段取决于上传策略的设置。
                                try {
                                    String img_name =  res.getString("key");
                                    if(store!=null){store.identityCardPicture= img_name;}//save the license
                                    String img_url = FPHelp.getInstance().getBaseIMGUrl()+img_name;
                                    Picasso.with(getApplicationContext())
                                            .load(img_url)
                                            .placeholder(R.drawable.biz_tie_comment_tag_default)
                                            .into(ivStoreHandIdCard);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, null);

            }

            @Override
            public void onHanlderFailure(int requestCode, String errorMsg) {

            }
        });
    }

    @OnClick(R.id.ivStoreBussinessCard)
    public void ivStoreBussinessCard(){
        GalleryFinal.openGallerySingle(1, new GalleryFinal.OnHanlderResultCallback() {
            @Override
            public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {

                UploadManager uploadManager = new UploadManager();
                String data = resultList.get(0).getPhotoPath();
                String key = null;
                String token = mPresenter.mToken.data;
                uploadManager.put(data, key, token,
                        new UpCompletionHandler() {
                            @Override
                            public void complete(String key, ResponseInfo info,JSONObject res) {
                                //  res 包含hash、key等信息，具体字段取决于上传策略的设置。
                                try {
                                    String img_name =  res.getString("key");
                                    if(store!=null){store.licenseId = img_name;}//save the license
                                    String img_url = FPHelp.getInstance().getBaseIMGUrl()+img_name;
                                    Picasso.with(getApplicationContext())
                                            .load(img_url)
                                            .placeholder(R.drawable.biz_tie_comment_tag_default)
                                            .into(ivStoreBussinessCard);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, null);

            }

            @Override
            public void onHanlderFailure(int requestCode, String errorMsg) {

            }
        });
    }



    @OnClick(R.id.iv_idcard)
    public void ivIdcard(){
        GalleryFinal.openGallerySingle(1, new GalleryFinal.OnHanlderResultCallback() {
            @Override
            public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {

                UploadManager uploadManager = new UploadManager();
                String data = resultList.get(0).getPhotoPath();
                String key = null;
                String token = mPresenter.mToken.data;
                uploadManager.put(data, key, token,
                        new UpCompletionHandler() {
                            @Override
                            public void complete(String key, ResponseInfo info,JSONObject res) {
                                //  res 包含hash、key等信息，具体字段取决于上传策略的设置。
                                try {
                                    String img_name =  res.getString("key");
                                    if(store!=null){store.identityCard = img_name;}//save the identityCard
                                    String img_url = FPHelp.getInstance().getBaseIMGUrl()+img_name;
                                    Picasso.with(getApplicationContext())
                                            .load(img_url)
                                            .placeholder(R.drawable.biz_tie_comment_tag_default)
                                            .into(ivIdcard);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, null);

            }

            @Override
            public void onHanlderFailure(int requestCode, String errorMsg) {

            }
        });
    }

    @OnClick(R.id.iv_store_face)
    public void ivStoreFace(){
        GalleryFinal.openGallerySingle(1, new GalleryFinal.OnHanlderResultCallback() {
            @Override
            public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {

                UploadManager uploadManager = new UploadManager();
                String data = resultList.get(0).getPhotoPath();
                String key = null;
                String token = mPresenter.mToken.data;
                uploadManager.put(data, key, token,
                        new UpCompletionHandler() {
                            @Override
                            public void complete(String key, ResponseInfo info,JSONObject res) {
                                //  res 包含hash、key等信息，具体字段取决于上传策略的设置。
                                try {
                                    String img_name =  res.getString("key");
                                    if(store!=null){store.storeFacePicture = img_name;}//save the storeface
                                    String img_url = FPHelp.getInstance().getBaseIMGUrl()+img_name;
                                    Picasso.with(getApplicationContext())
                                            .load(img_url)
                                            .placeholder(R.drawable.biz_tie_comment_tag_default)
                                            .into(ivStoreFace);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, null);

            }

            @Override
            public void onHanlderFailure(int requestCode, String errorMsg) {

            }
        });
    }

    @Override
    protected void initKProgressHUD() {

    }



    @Override
    public void showLoading(boolean isShow) {

    }

    @Override
    public void doSomthing(String msg, int code) {

    }

    @Override
    public void onTokenLoaded(QiNiuTokenData result) {
        if(result==null){
            ToastUtils.showLong("获取上传凭证失败!");
            this.finish();
        }
    }
}

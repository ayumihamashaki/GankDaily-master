package com.gudong.gankio.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.gudong.gankio.R;
import com.gudong.gankio.core.FPHelp;
import com.gudong.gankio.data.CollectData;
import com.gudong.gankio.data.StoresData;
import com.gudong.gankio.data.entity.Collect;
import com.gudong.gankio.presenter.AddressMangerPresenter;
import com.gudong.gankio.presenter.CollectMangerPresenter;
import com.gudong.gankio.ui.adapter.base.CommonAdapter;
import com.gudong.gankio.ui.adapter.base.ViewHolder;
import com.gudong.gankio.ui.sharp.CircleTransform;
import com.gudong.gankio.ui.view.IBaseView;
import com.gudong.gankio.ui.view.ICollectMangerView;
import com.gudong.gankio.util.DebugUtil;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.squareup.picasso.Picasso;

import butterknife.Bind;

/**
 * 我的收藏
 */
public class CollectMangerActivity extends BaseActivity<CollectMangerPresenter> implements ICollectMangerView {


    @Bind(R.id.lv_collect)ListView lv_collect;

    @Override
    protected void initKProgressHUD() {
        mKProgressHUD = KProgressHUD.create(this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("请等待")
                .setDetailsLabel("正在加载数据...");
    }

    @Override
    protected void initPresenter() {
        mPresenter = new CollectMangerPresenter(this,this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_collect_manger;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getResources().getString(R.string.action_title_mine_collect), true);
        mPresenter.getData();
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

    }

    @Override
    public void onDataLoad(CollectData collectDatas) {

        CommonAdapter commonAdapter = new CommonAdapter<Collect>(
                getApplicationContext(),
                collectDatas.data,
                R.layout.row_store){

            @Override
            public void convert(ViewHolder holder, Collect collect) {

                if(collect==null){return;}
                holder.setText(R.id.tv_store_name,collect.store.storeName);
                holder.setText(R.id.tv_store_address,collect.store.storeAddress);
                ImageView iv_store_face = holder.getView(R.id.iv_store_face);
                Picasso.with(getApplicationContext())
                        .load(FPHelp.getInstance().getBaseIMGUrl() + collect.store.storeFacePicture)
                        .placeholder(R.drawable.biz_tie_comment_tag_default)
                        .transform(new CircleTransform())
                        .into(iv_store_face);
            }
        };
        lv_collect.setAdapter(commonAdapter);
        lv_collect.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Collect _Collect = (Collect)parent.getItemAtPosition(position);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("store",_Collect.store);
                intent.putExtras(bundle);
                intent.setClass(CollectMangerActivity.this,StoreActivity.class);
                startActivity(intent);
            }
        });
    }
}

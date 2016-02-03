package com.gudong.gankio.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gudong.gankio.R;
import com.gudong.gankio.data.entity.Store;
import com.gudong.gankio.presenter.StoreProductPresenter;
import com.gudong.gankio.ui.adapter.MyRecycleViewApater;
import com.gudong.gankio.ui.view.IStoreProductView;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StoreProductFragment extends BaseFragment<StoreProductPresenter> implements IStoreProductView {

    @Bind(R.id.myrecyclerview)
    RecyclerView myrecyclerview;
    private Store store;

    @Override
    protected void initPresenter() {
        mPresenter = new StoreProductPresenter(getActivity(), StoreProductFragment.this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_store_product;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mToolbar.setVisibility(View.GONE);
        store = (Store) getActivity().getIntent().getExtras().getSerializable("store");



        myrecyclerview.setHasFixedSize(true);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

        String[] sCheeseStrings={"1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"
                ,"1","1","1","1","1","1","1","1","1","1","1","1","1","1"
                ,"1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"
                ,"1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"};

       String[] secitonTitle = {"1","2"};
        final MyRecycleViewApater myRecycleViewApater = new MyRecycleViewApater(secitonTitle);
        final StickyRecyclerHeadersDecoration _StickyRecyclerHeadersDecoration =new StickyRecyclerHeadersDecoration(myRecycleViewApater);
        myRecycleViewApater.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                _StickyRecyclerHeadersDecoration.invalidateHeaders();
            }
        });  //刷新数据的时候回刷新头部
        myrecyclerview.addItemDecoration(_StickyRecyclerHeadersDecoration);
        myrecyclerview.setAdapter(myRecycleViewApater);

    }

    @Override
    public void showLoading(boolean isShow) {

    }

    @Override
    public void doSomthing(String msg, int code) {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }



}

package com.gudong.gankio.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gudong.gankio.R;
import com.gudong.gankio.util.DebugUtil;
import com.mikepenz.fastadapter.adapters.FastItemAdapter;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;
import com.truizlop.sectionedrecyclerview.SectionedRecyclerViewAdapter;

/**
 * Created by rmtic on 2016/2/2.
 */
public class MyRecycleViewApater extends SectionedRecyclerViewAdapter<
        CountHeaderViewHolder,
        CountItemViewHolder,
        CountFooterViewHolder> implements StickyRecyclerHeadersAdapter{

    String[] secitonTitle;
    protected String[][] agenda = {{"Meeting", "Phone call", "Interview"},
            {"Basket match", "Grocery shopping", "Taking a nap"}};


    public MyRecycleViewApater(String[] secitonTitle) {
        this.secitonTitle = secitonTitle;
    }

    @Override
    protected int getSectionCount() {
        return 2;
    }

    @Override
    protected int getItemCountForSection(int section) {
        return 125;
    }

    @Override
    protected boolean hasFooterInSection(int section) {
        return false;
    }

    @Override
    protected CountHeaderViewHolder onCreateSectionHeaderViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_header, parent, false);
        return new CountHeaderViewHolder(view);
    }

    @Override
    protected CountFooterViewHolder onCreateSectionFooterViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_footer, parent, false);
        return new CountFooterViewHolder(view);
    }

    @Override
    protected CountItemViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_item, parent, false);
        return new CountItemViewHolder(view);
    }

    @Override
    protected void onBindSectionHeaderViewHolder(CountHeaderViewHolder holder, int section) {
        holder.tv_section_name.setText(secitonTitle[section]);
    }

    @Override
    protected void onBindSectionFooterViewHolder(CountFooterViewHolder holder, int section) {

    }

    @Override
    protected void onBindItemViewHolder(CountItemViewHolder holder, int section, int position) {

    }

    @Override
    public long getHeaderId(int position) {
        return 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, parent, false);
        return new CountHeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder = (CountHeaderViewHolder)holder;
        DebugUtil.i("positon:"+position);
                ((CountHeaderViewHolder) holder).tv_section_name.setText(secitonTitle[position]);
    }
}

package com.gudong.gankio.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.gudong.gankio.R;

/**
 * Created by rmtic on 2016/2/2.
 */
public class CountHeaderViewHolder extends RecyclerView.ViewHolder{

    TextView tv_section_name;

    public CountHeaderViewHolder(View view) {
        super(view);
        tv_section_name = (TextView)view.findViewById(R.id.tv_section_name);
    }
}

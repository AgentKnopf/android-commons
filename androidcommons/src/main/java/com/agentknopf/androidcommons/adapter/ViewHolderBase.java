package com.agentknopf.androidcommons.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by AgentKnopf on 12.12.2015.
 */
public abstract class ViewHolderBase<T> extends RecyclerView.ViewHolder {
    /**
     * Create your Viewholder and inflate the required layout.
     *
     * @param itemView
     */
    protected ViewHolderBase(View itemView) {
        super(itemView);
    }

    public abstract void bind(int position, T item);

    /**
     * @return root view for a row.
     */
    public abstract View getRowView();
}

package com.agentknopf.androidcommons.adapter;

import android.view.ViewGroup;

/**
 * Interface that needs to be implemented by the Creator class in {@Link ViewHolderBase} implementations.
 *
 * Created by AgentKnopf on 12.12.2015.
 */
public interface IViewHolderCreator<K extends ViewHolderBase> {

    public K onCreateViewHolder(ViewGroup parent);

}

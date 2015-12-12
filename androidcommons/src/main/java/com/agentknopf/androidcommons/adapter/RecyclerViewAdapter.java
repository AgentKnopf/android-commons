package com.agentknopf.androidcommons.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AgentKnopf on 12.12.2015.
 */
public class RecyclerViewAdapter<T> extends RecyclerView.Adapter<ViewHolderBase<T>> {

    private static final String TAG = "RecyclerViewAdapter";
    public static final int VIEW_TYPE_DEFAULT = 0;

    private List<T> items = new ArrayList<>();
    private SparseArray<IViewHolderCreator> typeToCreator;

    public void add(T item) {
        items.add(item);
    }

    public void clearItems() {
        items.clear();
    }

    public void addAll(List<T> items) {
        this.items.addAll(items);
    }

    /**
     * Creates a recycler view with a basic viewtype/creator
     *
     * @param viewType the view type that the view holder returned by the creator handles.
     * @param creator  creates an instance of the viewholder that handles the given viewtype.
     */
    public RecyclerViewAdapter(int viewType, IViewHolderCreator creator) {
        typeToCreator = new SparseArray<>(1);
        typeToCreator.put(viewType, creator);
    }

    @Override
    public ViewHolderBase onCreateViewHolder(ViewGroup parent, int viewType) {
        return typeToCreator.get(viewType).onCreateViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(ViewHolderBase holder, int position) {
        holder.bind(position, items.get(position));
    }

    public T getItemAt(int position) {
        return items.get(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}

package com.agentknopf.androidcommons.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by AgentKnopf on 12.12.2015.
 */
public class RecyclerViewAdapter<T> extends RecyclerViewAdapterBase<T> {

    private final List<T> items = new ArrayList<>();

    /**
     * Creates a recycler view with a basic viewtype/creator
     *
     * @param viewType the view type that the view holder returned by the creator handles.
     * @param creator  creates an instance of the viewholder that handles the given viewtype.
     */
    public RecyclerViewAdapter(int viewType, IViewHolderCreator creator) {
        super(viewType, creator);
    }

    @Override
    public void add(T item) {
        items.add(item);
        notifyDataSetChanged();
    }

    @Override
    protected T getItemAt(int position) {
        return items.get(position);
    }

    @Override
    protected void clearItems() {
        items.clear();
    }

    public void replaceAll(T[] items) {
        clearItems();
        addAll(toList(items));
        notifyDataSetChanged();
    }

    private List<T> toList(T[] items) {
        List<T> newList = Arrays.asList(items);
        if (isReverseOrder()) Collections.reverse(newList);
        return newList;
    }

    public void addAll(List<T> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void replaceAll(List<T> items) {
        clearItems();
        if (isReverseOrder()) Collections.reverse(items);
        addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}

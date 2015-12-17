package com.agentknopf.androidcommons.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by AgentKnopf on 12.12.2015.
 */
public class RecyclerViewAdapter<T> extends RecyclerView.Adapter<ViewHolderBase<T>> {

    private static final String TAG = "RecyclerViewAdapter";
    public static final int VIEW_TYPE_DEFAULT = 0;

    /**
     * Interested parties can subscribe to receive onClickPropagator events which will deliver the position as well as the item itself.
     * Subscribers must implement a corresponding onEvent method, depending on whether they want to receive results on the UI - or a background thread.
     */
    public final EventBus onClickPropagator;

    private final List<T> items = new ArrayList<>();
    private final SparseArray<IViewHolderCreator> typeToCreator;

    public void add(T item) {
        items.add(item);
    }

    public void clear() {
        items.clear();
    }

    public void addAll(List<T> items) {
        this.items.addAll(items);
    }

    public void replaceAll(List<T> items) {
        clear();
        addAll(items);
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
        onClickPropagator = EventBus.builder()
                .eventInheritance(false)
                .build();
    }

    @Override
    public ViewHolderBase onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolderBase holder = typeToCreator.get(viewType).onCreateViewHolder(parent);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolderBase holder, final int position) {
        holder.bind(position, items.get(position));
        holder.getRowView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickPropagator.post(items.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
     * Register for on-click events. Make sure to provide an onEvent method implementation, receiving an instance of T
     * to handle the actual clicks. Also: Make sure to unsubscribe, in case you are no longer interested in receiving on-click updates.
     *
     * @param subscriber
     */
    public void registerForOnClick(Object subscriber) {
        onClickPropagator.register(subscriber);
    }

    /**
     * Unsubscribes from on-click events.
     *
     * @param subscriber
     */
    public void unregisterForOnClick(Object subscriber) {
        onClickPropagator.unregister(subscriber);
    }

}

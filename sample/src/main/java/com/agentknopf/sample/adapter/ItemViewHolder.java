package com.agentknopf.sample.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.agentknopf.androidcommons.adapter.IViewHolderCreator;
import com.agentknopf.androidcommons.adapter.ViewHolderBase;
import com.agentknopf.sample.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AgentKnopf on 12.12.2015.
 */
public class ItemViewHolder extends ViewHolderBase<RecyclerViewActivity.Item> {

    final View rootView;
    @Bind(R.id.textview)
    TextView textView;

    /**
     * Create your Viewholder and inflate the required layout.
     *
     * @param itemView
     */
    protected ItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.rootView = itemView;
    }

    @Override
    public void bind(int position, RecyclerViewActivity.Item item) {
        textView.setText(String.format("%s %s", item.getText(), position));
    }

    @Override
    public View getRowView() {
        return rootView;
    }

    public static final class Creator implements IViewHolderCreator<ItemViewHolder> {

        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent) {
            return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_recyclerview_row, parent, false));
        }
    }
}

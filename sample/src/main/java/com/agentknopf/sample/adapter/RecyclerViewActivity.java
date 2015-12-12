package com.agentknopf.sample.adapter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.agentknopf.androidcommons.adapter.RecyclerViewAdapter;
import com.agentknopf.sample.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Demonstrates usage of RecyclerViewAdapter and ViewHolderBase.
 */
public class RecyclerViewActivity extends AppCompatActivity {

    private static final String TAG = "RecyclerViewActivity";
    private final List<Item> items = new ArrayList<>(20);

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.recyclerview)
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapter(RecyclerViewAdapter.VIEW_TYPE_DEFAULT, new ItemViewHolder.Creator());
        adapter.registerForOnClick(this);
        adapter.addAll(getItems());
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        adapter.unregisterForOnClick(this);
    }

    @OnClick(R.id.fab)
    public void onFabClicked() {
        Snackbar.make(fab, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    private List<Item> getItems() {
        if (items.isEmpty()) {
            for (int i = 0, size = 20; i < size; i++) {
                items.add(i, new Item());
            }
        }
        return items;
    }

    /**
     * Dummy item that will be held by the recyclerview adapter.
     * Created by AgentKnopf on 12.12.2015.
     */
    public static class Item {
        private final String text;
        private int position;

        public Item() {
            text = "Item";
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getPosition() {
            return position;
        }

        public String getText() {
            return text;
        }
    }

    public void onEventMainThread(Item onClicked){
        Log.i(TAG, "Clicked on item at position " + onClicked.getPosition());
    }
}

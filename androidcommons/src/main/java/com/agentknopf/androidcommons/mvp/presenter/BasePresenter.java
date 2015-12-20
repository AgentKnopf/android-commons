package com.agentknopf.androidcommons.mvp.presenter;

import android.os.Bundle;

/**
 * Base implementation that does nothing but allows you to only override the lifecycle methods you actually need.
 * Created by AgentKnopf on 17.12.2015.
 */
public abstract class BasePresenter implements IPresenter {

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onCreate(Bundle savedInstance) {

    }

    @Override
    public void onDestroy() {

    }
}

package com.agentknopf.androidcommons.mvp.presenter;

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
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }
}

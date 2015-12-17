package com.agentknopf.androidcommons.mvp.presenter;

/**
 * A presenter used by a view.
 *
 * Created by AgentKnopf on 13.12.2015.
 */
public interface IPresenter {

    /**
     * Callback for when a fragment is started.
     */
    void onStart();

    /**
     * Callback for when a fragment is stopped.
     */
    void onStop();

    /**
     * Should be called by the fragment when it gets created.
     */
    void onCreate();

    /**
     * Should be called by the fragment when it gets destroyed. Make sure to release all resources at this point.
     */
    void onDestroy();
}

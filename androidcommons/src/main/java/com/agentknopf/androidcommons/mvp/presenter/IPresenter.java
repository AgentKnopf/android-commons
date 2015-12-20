package com.agentknopf.androidcommons.mvp.presenter;

import android.os.Bundle;

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
     * @param savedInstance or the argument bundle initially passed to the fragment.
     */
    void onCreate(Bundle savedInstance);

    /**
     * Should be called by the fragment when it gets destroyed. Make sure to release all resources at this point.
     */
    void onDestroy();
}

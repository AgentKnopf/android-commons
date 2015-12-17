package com.agentknopf.androidcommons.mvp.presenter;

/**
 * A view interface implemented by views such as Fragments and Activities.
 * Created by AgentKnopf on 17.12.2015.
 */
public interface IView {

    /**
     * Shows a snackbar to the user.
     *
     * @param message text to display.
     * @param length  duration of text display.
     */
    void showSnackbar(String message, int length);

}

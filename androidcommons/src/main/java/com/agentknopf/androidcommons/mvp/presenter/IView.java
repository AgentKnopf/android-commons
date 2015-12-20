package com.agentknopf.androidcommons.mvp.presenter;

import android.support.design.widget.Snackbar;

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
    void showSnackbar(String message, @Snackbar.Duration int length);

    /**
     * Shows a snackbar to the user.
     *
     * @param stringResId res id of the text to display.
     * @param length      duration of text display.
     */
    void showSnackbar(int stringResId, @Snackbar.Duration int length);

    /**
     * Updates the fragments title with the given title.
     *
     * @param newTitle new title.
     */
    void setTitle(String newTitle);

}

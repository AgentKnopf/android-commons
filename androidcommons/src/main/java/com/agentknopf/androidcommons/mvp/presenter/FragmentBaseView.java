package com.agentknopf.androidcommons.mvp.presenter;

import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;

/**
 * Created by AgentKnopf on 19.12.2015.
 */
public class FragmentBaseView extends Fragment implements IView {

    @Override
    public void showSnackbar(String message, int length) {
        Snackbar.make(getView(), message, length).show();
    }

    @Override
    public void showSnackbar(int stringResId, @Snackbar.Duration int length) {
        showSnackbar(getString(stringResId), length);
    }

    @Override
    public void setTitle(String newTitle) {
        getActivity().setTitle(newTitle);
    }

}

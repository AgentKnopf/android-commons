package com.agentknopf.androidcommons.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;

/**
 * Android view/ui utility methods.
 *
 * Created by AgentKnopf on 13.12.2015.
 */
public final class UiUtils {
    private UiUtils() {
        throw new RuntimeException("UiUtils must not be instantiated.");
    }

    public static Drawable toDrawable(Context context, int resId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return context.getDrawable(resId);
        } else {
            return context.getResources().getDrawable(resId, context.getTheme());
        }
    }
}

package com.agentknopf.androidcommons.mvp.presenter;

import java.lang.ref.WeakReference;

/**
 * Can be used to keep a weak reference to anything - such as activity callbacks.
 * Created by AgentKnopf on 17.12.2015.
 */
public class WeakCallback<T> {
    private final WeakReference<T> reference;

    public WeakCallback(T reference) {
        this.reference = new WeakReference<T>(reference);
    }

    /**
     * @return true if the weak reference is still valid; false otherwise.
     */
    public boolean hasValidReference() {
        return reference.get() != null;
    }

    /**
     * Cleans up the reference.
     */
    public void clear() {
        reference.clear();
    }

    public T get() {
        return reference.get();
    }
}

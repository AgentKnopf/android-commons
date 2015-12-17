package com.agentknopf.androidcommons.eventbus;

import de.greenrobot.event.EventBus;

/**
 * Wrapper so we can switch the underlying event bus if need be.
 *
 * Created by FZARRAI on 30.11.2015.
 */
public final class Eventbus {

    private static final EventBus BUS = EventBus.getDefault();

    public static void register(Object subscriber) {
        if(!BUS.isRegistered(subscriber)){
            BUS.register(subscriber);
        }
    }

    public static void unregister(Object subscriber) {
        if(BUS.isRegistered(subscriber)){
            BUS.unregister(subscriber);
        }
    }

    public static void post(Object toPost) {
        BUS.post(toPost);
    }

}


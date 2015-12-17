package com.agentknopf.androidcommons.rxjava;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Transformer for when you need subscription on a background thread and observation on the main thread.
 * To use it simply create an instance of the scheduler (keep it around if you use it often, no need to re-create it each time)
 * and on the observable call .compose(transformer) - this will then apply the subscribeOn and observeOn implementations of this
 * transformer.
 * <p/>
 * Created by AgentKnopf on 17.12.2015.
 */
public class SchedulerTransformer<T> implements Observable.Transformer<T, T> {
    @Override
    public Observable<T> call(Observable<T> observable) {
        return observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
}

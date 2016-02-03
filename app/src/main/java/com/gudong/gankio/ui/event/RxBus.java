package com.gudong.gankio.ui.event;

/**
 * Created by rmtic on 2016/1/29.
 */


import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

public class RxBus {

    private final PublishSubject<BusEvent> publishSubject =  PublishSubject.create();
    private final Subject<BusEvent, BusEvent> mBus = new SerializedSubject<BusEvent, BusEvent>(publishSubject);

    private static class RxBusHolder {
        private static final RxBus INSTANCE = new RxBus();
    }

    private RxBus() {}

    public static final RxBus getInstance() {
        return RxBusHolder.INSTANCE;
    }

    public void send(BusEvent event) {
        mBus.onNext(event);
    }

    public Observable<BusEvent> toObserverable() {
        return mBus;
    }

    public boolean hasObservers() {
        return mBus.hasObservers();
    }

    public static class BusEvent {}
}

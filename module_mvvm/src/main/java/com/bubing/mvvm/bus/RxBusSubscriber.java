package com.bubing.mvvm.bus;

import io.reactivex.observers.DisposableObserver;

/**
 * @ClassName: RxBusSubscriber
 * @Author: Bubing
 * @Date: 2020/8/4 5:36 PM
 * @Description: 为RxBus使用的Subscriber, 主要提供next事件的try,catch
 */
public abstract class RxBusSubscriber<T> extends DisposableObserver<T> {

    @Override
    public void onNext(T t) {
        try {
            onEvent(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onComplete() {
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    protected abstract void onEvent(T t);
}

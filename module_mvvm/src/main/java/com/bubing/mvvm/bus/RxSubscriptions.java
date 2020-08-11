package com.bubing.mvvm.bus;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @ClassName: RxSubscriptions
 * @Description: 管理 CompositeSubscription
 * @Author: Bubing
 * @Date: 2020/8/4 11:36 AM
 */
public class RxSubscriptions {
    private static CompositeDisposable mSubscriptions = new CompositeDisposable();

    public static boolean isDisposed() {
        return mSubscriptions.isDisposed();
    }

    public static void add(Disposable s) {
        if (s != null) {
            mSubscriptions.add(s);
        }
    }

    public static void remove(Disposable s) {
        if (s != null) {
            mSubscriptions.remove(s);
        }
    }

    public static void clear() {
        mSubscriptions.clear();
    }

    public static void dispose() {
        mSubscriptions.dispose();
    }

}

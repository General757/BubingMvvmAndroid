package com.bubing.mvvm.base;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.bubing.mvvm.bus.event.SingleLiveEvent;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @ClassName: BaseViewModel
 * @Description: 基础-ViewModel
 * @Author: Bubing
 * @Date: 2020/8/1 5:08 PM
 */
public class BaseViewModel<M extends BaseModel> extends AndroidViewModel implements IBaseViewModel, Consumer<Disposable> {
    protected M model;
    private UIChangeLiveData uc;
    //弱引用持有
    private WeakReference<LifecycleProvider> lifecycle;
    //管理RxJava，主要针对RxJava异步操作造成的内存泄漏
    private CompositeDisposable compositeDisposable;

    public BaseViewModel(@NonNull Application application) {
        this(application, null);
    }

    public BaseViewModel(@NonNull Application application, M model) {
        super(application);
        this.model = model;
        compositeDisposable = new CompositeDisposable();
    }

    protected void addSubscribe(Disposable disposable) {
        if (compositeDisposable == null)
            compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(disposable);
    }

    /**
     * 注入RxLifecycle生命周期
     *
     * @param lifecycle
     */
    public void injectLifecycleProvider(LifecycleProvider lifecycle) {
        this.lifecycle = new WeakReference<LifecycleProvider>(lifecycle);
    }

    public LifecycleProvider getLifecycleProvider() {
        return this.lifecycle.get();
    }

    public UIChangeLiveData getUC() {
        if (uc == null)
            uc = new UIChangeLiveData();
        return uc;
    }

    public void showDialog() {
        showDialog("请稍后...");
    }

    public void showDialog(String msg) {
        uc.showDialogEvent.postValue(msg);
    }

    public void dismissDialog() {
        uc.dismissDialogEvent.call();
    }

    public void startActivity(Class<?> clz) {
        startActivity(clz, null);
    }

    /**
     * 跳转页面
     *
     * @param clz    所跳转的目的Activity类
     * @param bundle 跳转所携带的信息
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(ParameterField.CLASS, clz);
        if (bundle != null)
            params.put(ParameterField.BUNDLE, bundle);
        uc.startActivityEvent.postValue(params);
    }

    public void startContainerActivity(String canonicalName) {
        startContainerActivity(canonicalName, null);
    }

    /**
     * 关闭界面
     */
    public void finish() {
        uc.finishEvent.call();
    }

    /**
     * 返回上一层
     */
    public void onBackPressed() {
        uc.onBackPressedEvent.call();
    }

    @Override
    public void onAny(LifecycleOwner owner, Lifecycle.Event event) {

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onPasue() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void registerRxBus() {

    }

    @Override
    public void removeRxBus() {

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (model != null)
            model.onCleared();
        ////ViewModel销毁时会执行，同时取消所有异步任务
        if (compositeDisposable != null)
            compositeDisposable.clear();
    }

    @Override
    public void accept(Disposable disposable) throws Exception {
        addSubscribe(disposable);
    }

    /**
     * 跳转容器页面
     *
     * @param canonicalName 规范名 : Fragment.class.getCanonicalName()
     * @param bundle        跳转所携带的信息
     */
    public void startContainerActivity(String canonicalName, Bundle bundle) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(ParameterField.CANONICAL_NAME, canonicalName);
        if (bundle != null)
            params.put(ParameterField.BUNDLE, bundle);
        uc.startContainerActivityEvent.postValue(params);
    }

    public final class UIChangeLiveData extends SingleLiveEvent {
        private SingleLiveEvent<String> showDialogEvent;
        private SingleLiveEvent<Void> dismissDialogEvent;
        private SingleLiveEvent<Map<String, Object>> startActivityEvent;
        private SingleLiveEvent<Map<String, Object>> startContainerActivityEvent;
        private SingleLiveEvent<Void> finishEvent;
        private SingleLiveEvent<Void> onBackPressedEvent;

        public SingleLiveEvent<String> getShowDialogEvent() {
            return showDialogEvent = createLiveData(showDialogEvent);
        }

        public SingleLiveEvent<Void> getDismissDialogEvent() {
            return dismissDialogEvent = createLiveData(dismissDialogEvent);
        }

        public SingleLiveEvent<Map<String, Object>> getStartActivityEvent() {
            return startActivityEvent = createLiveData(startActivityEvent);
        }

        public SingleLiveEvent<Map<String, Object>> getStartContainerActivityEvent() {
            return startContainerActivityEvent = createLiveData(startContainerActivityEvent);
        }

        public SingleLiveEvent<Void> getFinishEvent() {
            return finishEvent = createLiveData(finishEvent);
        }

        public SingleLiveEvent<Void> getOnBackPressedEvent() {
            return onBackPressedEvent = createLiveData(onBackPressedEvent);
        }

        private <T> SingleLiveEvent<T> createLiveData(SingleLiveEvent<T> liveEvent) {
            if (liveEvent == null)
                liveEvent = new SingleLiveEvent<T>();
            return liveEvent;
        }

        @Override
        public void observe(@NonNull LifecycleOwner owner, @NonNull Observer observer) {
            super.observe(owner, observer);
        }
    }

    public static final class ParameterField {
        public static String CLASS = "CLASS";
        public static String CANONICAL_NAME = "CANONICAL_NAME";
        public static String BUNDLE = "BUNDLE";
    }
}

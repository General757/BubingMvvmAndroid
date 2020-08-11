package com.bubing.android.app;

import com.bubing.android.BuildConfig;
import com.bubing.android.R;
import com.bubing.android.ui.login.LoginActivity;
import com.bubing.mvvm.base.BaseApplication;
import com.bubing.mvvm.crash.CrashConfig;
import com.bubing.mvvm.utils.KLog;
import com.squareup.leakcanary.LeakCanary;

/**
 * @ClassName: AppApplication
 * @Description: java类作用描述
 * @Author: Bubing
 * @Date: 2020/8/3 5:29 PM
 */
public class AppApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        //是否开启打印日志
        KLog.init(BuildConfig.DEBUG);
        //初始化全局异常崩溃
        initCrash();
        // 内存泄漏检测
        if (!LeakCanary.isInAnalyzerProcess(this))
            LeakCanary.install(this);
    }

    private void initCrash() {
        CrashConfig.Builder.create()
                .backgroundMode(CrashConfig.BACKGROUND_MODE_SILENT) //背景模式,开启沉浸式
                .enabled(true) //是否启动全局异常捕获
                .showErrorDetails(true) //是否显示错误详细信息
                .showRestartButton(true) //是否显示重启按钮
                .trackActivities(true) //是否跟踪Activity
                .minTimeBetweenCrashesMs(2000) //崩溃的间隔时间(毫秒)
                .errorDrawable(R.mipmap.ic_launcher) //错误图标
                .restartActivity(LoginActivity.class) //重新启动后的activity
//                .errorActivity(YourCustomErrorActivity.class) //崩溃后的错误activity
//                .eventListener(new YourCustomEventListener()) //崩溃后的错误监听
                .apply();
    }
}

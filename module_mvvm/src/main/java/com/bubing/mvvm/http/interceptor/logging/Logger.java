package com.bubing.mvvm.http.interceptor.logging;

import okhttp3.internal.platform.Platform;

/**
 * @ClassName: Logger
 * @Description: java类作用描述
 * @Author: Bubing
 * @Date: 2020/8/3 4:47 PM
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface Logger {
    void log(int level, String tag, String msg);

    Logger DEFAULT = new Logger() {
        @Override
        public void log(int level, String tag, String message) {
            Platform.get().log(level, message, null);
        }
    };
}

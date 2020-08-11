package com.bubing.mvvm.utils.compression;

import java.io.File;

/**
 * @ClassName: OnCompressListener
 * @Author: Bubing
 * @Date: 2020/8/4 5:28 PM
 * @Description: 压缩回调接口
 */
public interface OnCompressListener {

    /**
     * Fired when the compression is started, override to handle in your own code
     */
    void onStart();

    /**
     * Fired when a compression returns successfully, override to handle in your own code
     */
    void onSuccess(File file);

    /**
     * Fired when a compression fails to complete, override to handle in your own code
     */
    void onError(Throwable e);
}

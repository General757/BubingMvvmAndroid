package com.bubing.mvvm.http;

/**
 * @ClassName: ResponseThrowable
 * @Description: java类作用描述
 * @Author: Bubing
 * @Date: 2020/8/3 3:21 PM
 */
public class ResponseThrowable extends Exception {
    public int code;
    public String message;

    public ResponseThrowable(Throwable throwable, int code) {
        super(throwable);
        this.code = code;
    }
}

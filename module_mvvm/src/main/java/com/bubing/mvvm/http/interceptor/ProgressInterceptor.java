package com.bubing.mvvm.http.interceptor;

import com.bubing.mvvm.http.download.ProgressResponseBody;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * @ClassName: ProgressInterceptor
 * @Description: java类作用描述
 * @Author: Bubing
 * @Date: 2020/8/4 11:38 AM
 */
public class ProgressInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        return originalResponse.newBuilder()
                .body(new ProgressResponseBody(originalResponse.body()))
                .build();
    }
}

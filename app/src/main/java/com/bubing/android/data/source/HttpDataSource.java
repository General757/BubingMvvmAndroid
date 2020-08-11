package com.bubing.android.data.source;

import com.bubing.android.entity.LoginEntity;
import com.bubing.mvvm.http.BaseResponse;

import io.reactivex.Observable;

/**
 * @ClassName: HttpDataSource
 * @Description: java类作用描述
 * @Author: Bubing
 * @Date: 2020/8/3 2:50 PM
 */
public interface HttpDataSource {
    //模拟登录
    Observable<Object> login();

    //模拟上拉加载
    Observable<LoginEntity> loadMore();

    Observable<BaseResponse<LoginEntity>> demoGet();

    Observable<BaseResponse<LoginEntity>> demoPost(String catalog);
}

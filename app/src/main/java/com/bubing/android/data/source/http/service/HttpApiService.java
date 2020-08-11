package com.bubing.android.data.source.http.service;

import com.bubing.android.entity.LoginEntity;
import com.bubing.mvvm.http.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @ClassName: HttpApiService
 * @Description: java类作用描述
 * @Author: Bubing
 * @Date: 2020/8/3 4:14 PM
 */
public interface HttpApiService {

    @GET("action/apiv2/banner?catalog=1")
    Observable<BaseResponse<LoginEntity>> demoGet();

    @FormUrlEncoded
    @POST("action/apiv2/banner")
    Observable<BaseResponse<LoginEntity>> demoPost(@Field("catalog") String catalog);
}

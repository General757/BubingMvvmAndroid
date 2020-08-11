package com.bubing.android.data.source.http;

import com.bubing.android.data.source.HttpDataSource;
import com.bubing.android.data.source.http.service.HttpApiService;
import com.bubing.android.entity.LoginEntity;
import com.bubing.mvvm.http.BaseResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * @ClassName: HttpDataSourceImpl
 * @Description: java类作用描述
 * @Author: Bubing
 * @Date: 2020/8/3 4:54 PM
 */
public class HttpDataSourceImpl implements HttpDataSource {
    private HttpApiService apiService;
    private volatile static HttpDataSourceImpl INSTANCE = null;

    public static HttpDataSourceImpl getInstance(HttpApiService apiService) {
        if (INSTANCE == null) {
            synchronized (HttpDataSourceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HttpDataSourceImpl(apiService);
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    private HttpDataSourceImpl(HttpApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<Object> login() {
        return Observable.just(new Object()).delay(3, TimeUnit.SECONDS); //延迟3秒
    }

    @Override
    public Observable<LoginEntity> loadMore() {
        return Observable.create(new ObservableOnSubscribe<LoginEntity>() {
            @Override
            public void subscribe(ObservableEmitter<LoginEntity> observableEmitter) throws Exception {
                LoginEntity entity = new LoginEntity();
                List<LoginEntity.ItemsEntity> itemsEntities = new ArrayList<LoginEntity.ItemsEntity>();
                //模拟一部分假数据
                for (int i = 0; i < 10; i++) {
                    LoginEntity.ItemsEntity item = new LoginEntity.ItemsEntity();
                    item.setId(-1);
                    item.setName("模拟条目");
                    itemsEntities.add(item);
                }
                entity.setItems(itemsEntities);
                observableEmitter.onNext(entity);
            }
        }).delay(3, TimeUnit.SECONDS); //延迟3秒
    }

    @Override
    public Observable<BaseResponse<LoginEntity>> demoGet() {
        return apiService.demoGet();
    }

    @Override
    public Observable<BaseResponse<LoginEntity>> demoPost(String catalog) {
        return apiService.demoPost(catalog);
    }
}

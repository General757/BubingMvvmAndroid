package com.bubing.android.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

import com.bubing.android.data.source.HttpDataSource;
import com.bubing.android.data.source.LocalDataSource;
import com.bubing.android.entity.LoginEntity;
import com.bubing.mvvm.base.BaseModel;
import com.bubing.mvvm.http.BaseResponse;

import io.reactivex.Observable;

/**
 * @ClassName: RepositoryModel
 * @Description: MVVM的Model层，统一模块的数据仓库，包含网络数据和本地数据（一个应用可以有多个Repositor）
 * @Author: Bubing
 * @Date: 2020/8/3 2:47 PM
 */
public class RepositoryModel extends BaseModel implements HttpDataSource, LocalDataSource {

    private volatile static RepositoryModel INSTANCE = null;
    private final HttpDataSource mHttpDataSource;
    private final LocalDataSource mLocalDataSource;

    private RepositoryModel(@NonNull HttpDataSource httpDataSource, @NonNull LocalDataSource localDataSource) {
        this.mHttpDataSource = httpDataSource;
        this.mLocalDataSource = localDataSource;
    }

    public static RepositoryModel getInstance(HttpDataSource httpDataSource, LocalDataSource localDataSource) {
        if (INSTANCE == null) {
            synchronized (RepositoryModel.class) {
                if (INSTANCE == null)
                    INSTANCE = new RepositoryModel(httpDataSource, localDataSource);
            }
        }
        return INSTANCE;
    }

    @VisibleForTesting
    public static void destoryInstance() {
        INSTANCE = null;
    }

    @Override
    public Observable<Object> login() {
        return mHttpDataSource.login();
    }

    @Override
    public Observable<LoginEntity> loadMore() {
        return mHttpDataSource.loadMore();
    }

    @Override
    public Observable<BaseResponse<LoginEntity>> demoGet() {
        return mHttpDataSource.demoGet();
    }

    @Override
    public Observable<BaseResponse<LoginEntity>> demoPost(String catalog) {
        return mHttpDataSource.demoPost(catalog);
    }

    @Override
    public void saveUserName(String userName) {
        mLocalDataSource.saveUserName(userName);
    }

    @Override
    public void savePassword(String password) {
        mLocalDataSource.savePassword(password);
    }

    @Override
    public String getUserName() {
        return mLocalDataSource.getUserName();
    }

    @Override
    public String getPassword() {
        return mLocalDataSource.getPassword();
    }
}

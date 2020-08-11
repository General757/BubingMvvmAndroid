package com.bubing.android.app;

import com.bubing.android.data.RepositoryModel;
import com.bubing.android.data.source.HttpDataSource;
import com.bubing.android.data.source.LocalDataSource;
import com.bubing.android.data.source.http.HttpDataSourceImpl;
import com.bubing.android.data.source.http.service.HttpApiService;
import com.bubing.android.data.source.local.LocalDataSourceImpl;
import com.bubing.android.utils.RetrofitClient;

/**
 * @ClassName: Injection
 * @Author: Bubing
 * @Date: 2020/8/3 4:12 PM
 * @Description: 注入全局的数据仓库，可以考虑使用Dagger2。（根据项目实际情况搭建，千万不要为了架构而架构）
 */
public class Injection {

    public static RepositoryModel provideDemoRepository() {
        //网络API服务
        HttpApiService apiService = RetrofitClient.getInstance().create(HttpApiService.class);
        //网络数据源
        HttpDataSource httpDataSource = HttpDataSourceImpl.getInstance(apiService);
        //本地数据源
        LocalDataSource localDataSource = LocalDataSourceImpl.getInstance();
        //两条分支组成一个数据仓库
        return RepositoryModel.getInstance(httpDataSource, localDataSource);
    }
}

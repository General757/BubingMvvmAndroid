package com.bubing.android.ui.network.detail;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import com.bubing.android.entity.LoginEntity;
import com.bubing.mvvm.base.BaseViewModel;

/**
 * @ClassName: DetailViewModel
 * @Description: java类作用描述
 * @Author: Bubing
 * @Date: 2020/8/3 3:57 PM
 */
public class DetailViewModel extends BaseViewModel {
    public ObservableField<LoginEntity.ItemsEntity> entity = new ObservableField<LoginEntity.ItemsEntity>();

    public DetailViewModel(@NonNull Application application) {
        super(application);
    }

    public void setDemoEntity(LoginEntity.ItemsEntity entity) {
        this.entity.set(entity);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        entity = null;
    }
}

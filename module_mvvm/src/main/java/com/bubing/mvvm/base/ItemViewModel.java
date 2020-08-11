package com.bubing.mvvm.base;

import androidx.annotation.NonNull;

/**
 * @ClassName: ItemViewModel
 * @Description: java类作用描述
 * @Author: Bubing
 * @Date: 2020/8/3 3:50 PM
 */
public class ItemViewModel<VM extends BaseViewModel> {
    protected VM viewModel;

    public ItemViewModel(@NonNull VM viewModel) {
        this.viewModel = viewModel;
    }
}

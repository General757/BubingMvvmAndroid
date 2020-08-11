package com.bubing.mvvm.base;

import androidx.annotation.NonNull;

/**
 * @ClassName: MultiItemViewModel
 * @Description: RecycleView多布局ItemViewModel是封装
 * @Author: Bubing
 * @Date: 2020/8/4 1:16 PM
 */
public class MultiItemViewModel<VM extends BaseViewModel> extends ItemViewModel<VM> {
    protected Object multiType;

    public Object getItemType() {
        return multiType;
    }

    public void multiItemType(@NonNull Object multiType) {
        this.multiType = multiType;
    }

    public MultiItemViewModel(@NonNull VM viewModel) {
        super(viewModel);
    }
}

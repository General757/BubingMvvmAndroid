package com.bubing.mvvm.binding.viewadapter.viewgroup;

import androidx.databinding.ViewDataBinding;

/**
 * @ClassName: IBindingItemViewModel
 * @Description: java类作用描述
 * @Author: Bubing
 * @Date: 2020/8/4 10:39 AM
 */
public interface IBindingItemViewModel<V extends ViewDataBinding> {
    void injecDataBinding(V binding);
}

package com.bubing.android.ui.network;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;

/**
 * @ClassName: RecycleBindingAdapter
 * @Author: Bubing
 * @Date: 2020/8/4 3:58 PM
 * @Description: java类作用描述
 */
public class RecycleBindingAdapter extends BindingRecyclerViewAdapter {
    @Override
    public void onBindBinding(@NonNull ViewDataBinding binding, int variableId, int layoutRes, int position, Object item) {
        super.onBindBinding(binding, variableId, layoutRes, position, item);
    }
}

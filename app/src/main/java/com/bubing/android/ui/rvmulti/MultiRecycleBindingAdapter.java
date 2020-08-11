package com.bubing.android.ui.rvmulti;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;

/**
 * @ClassName: MultiRecycleBindingAdapter
 * @Author: Bubing
 * @Date: 2020/8/4 4:01 PM
 * @Description: java类作用描述
 */
public class MultiRecycleBindingAdapter extends BindingRecyclerViewAdapter {
    @Override
    public void onBindBinding(@NonNull ViewDataBinding binding, int variableId, int layoutRes, int position, Object item) {
        super.onBindBinding(binding, variableId, layoutRes, position, item);
    }
}

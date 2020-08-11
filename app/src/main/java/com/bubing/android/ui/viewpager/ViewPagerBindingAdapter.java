package com.bubing.android.ui.viewpager;

import android.view.ViewGroup;

import androidx.databinding.ViewDataBinding;

import com.bubing.android.databinding.ItemViewpagerBinding;

import me.tatarka.bindingcollectionadapter2.BindingViewPagerAdapter;

/**
 * @ClassName: ViewPagerBindingAdapter
 * @Author: Bubing
 * @Date: 2020/8/4 1:41 PM
 * @Description: java类作用描述
 */
public class ViewPagerBindingAdapter extends BindingViewPagerAdapter<ViewPagerItemViewModel> {

    @Override
    public void onBindBinding(final ViewDataBinding binding, int variableId, int layoutRes, final int position, ViewPagerItemViewModel item) {
        super.onBindBinding(binding, variableId, layoutRes, position, item);
        //这里可以强转成ViewPagerItemViewModel对应的ViewDataBinding，
        ItemViewpagerBinding _binding = (ItemViewpagerBinding) binding;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}

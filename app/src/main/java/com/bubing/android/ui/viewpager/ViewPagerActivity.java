package com.bubing.android.ui.viewpager;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.bubing.android.BR;
import com.bubing.android.R;
import com.bubing.android.databinding.ActivityViewpagerBinding;
import com.bubing.mvvm.base.BaseActivity;
import com.bubing.mvvm.utils.ToastUtils;
import com.google.android.material.tabs.TabLayout;

/**
 * @ClassName: ViewPagerActivity
 * @Author: Bubing
 * @Date: 2020/8/4 1:04 PM
 * @Description: ViewPager绑定的例子, 更多绑定方式，请参考 https://github.com/evant/binding-collection-adapter
 * 所有例子仅做参考,千万不要把它当成一种标准,毕竟主打的不是例子,业务场景繁多,理解如何使用才最重要。
 */
public class ViewPagerActivity extends BaseActivity<ActivityViewpagerBinding, ViewPagerViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_viewpager;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }


    @Override
    public void initData() {
        // 使用 TabLayout 和 ViewPager 相关联
        binding.tabs.setupWithViewPager(binding.viewPager);
        binding.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabs));
        //给ViewPager设置adapter
        binding.setAdapter(new ViewPagerBindingAdapter());
    }

    @Override
    public void initViewObservable() {
        viewModel.itemClickEvent.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String text) {
                ToastUtils.showShort("position：" + text);
            }
        });
    }
}

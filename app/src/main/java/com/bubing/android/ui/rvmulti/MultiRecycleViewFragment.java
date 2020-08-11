package com.bubing.android.ui.rvmulti;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.bubing.android.BR;
import com.bubing.android.R;
import com.bubing.android.databinding.FragmentMultiRecycleviewBinding;
import com.bubing.mvvm.base.BaseFragment;

import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;

/**
 * @ClassName: MultiRecycleViewFragment
 * @Description: RecycleView多布局实现
 * @Author: Bubing
 * @Date: 2020/8/4 12:58 PM
 */
public class MultiRecycleViewFragment extends BaseFragment<FragmentMultiRecycleviewBinding, MultiRecycleViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_multi_recycleview;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        //给RecyclerView添加Adpter，请使用自定义的Adapter继承BindingRecyclerViewAdapter，重写onBindBinding方法，里面有你要的Item对应的binding对象。
        // Adapter属于View层的东西, 不建议定义到ViewModel中绑定，以免内存泄漏
        binding.setAdapter(new MultiRecycleBindingAdapter());
    }

    @Override
    public MultiRecycleViewModel initViewModel() {
        return super.initViewModel();
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
    }
}

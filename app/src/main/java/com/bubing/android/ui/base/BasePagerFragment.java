package com.bubing.android.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bubing.android.BR;
import com.bubing.android.R;
import com.bubing.android.databinding.FragmentBasePagerBinding;
import com.bubing.mvvm.base.BaseFragment;
import com.bubing.mvvm.base.BaseViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

/**
 * @ClassName: BasePagerFragment
 * @Author: Bubing
 * @Date: 2020/8/4 1:49 PM
 * @Description: 抽取的二级BasePagerFragment
 */
public abstract class BasePagerFragment extends BaseFragment<FragmentBasePagerBinding, BaseViewModel> {

    private List<Fragment> mFragments;
    private List<String> titlePager;

    protected abstract List<Fragment> pagerFragment();

    protected abstract List<String> pagerTitleString();

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_base_pager;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        mFragments = pagerFragment();
        titlePager = pagerTitleString();
        //设置Adapter
        BaseFragmentPagerAdapter pagerAdapter = new BaseFragmentPagerAdapter(getChildFragmentManager(), mFragments, titlePager);
        binding.viewPager.setAdapter(pagerAdapter);
        binding.tabs.setupWithViewPager(binding.viewPager);
        binding.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabs));
    }

    @Override
    public void initViewObservable() {
    }
}

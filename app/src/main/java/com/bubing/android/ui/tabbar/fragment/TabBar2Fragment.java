package com.bubing.android.ui.tabbar.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.bubing.android.BR;
import com.bubing.android.R;
import com.bubing.mvvm.base.BaseFragment;

/**
 * @ClassName: TabBar2Fragment
 * @Author: Bubing
 * @Date: 2020/8/4 1:08 PM
 * @Description:
 */
public class TabBar2Fragment extends BaseFragment {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_tabbar2;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

}

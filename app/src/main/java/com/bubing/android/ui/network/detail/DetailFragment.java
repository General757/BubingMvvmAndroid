package com.bubing.android.ui.network.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bubing.android.BR;
import com.bubing.android.R;
import com.bubing.android.databinding.FragmentDetailBinding;
import com.bubing.android.entity.LoginEntity;
import com.bubing.mvvm.base.BaseFragment;

/**
 * @ClassName: DetailFragment
 * @Description: 详情界面
 * @Author: Bubing
 * @Date: 2020/8/3 3:54 PM
 */
public class DetailFragment extends BaseFragment<FragmentDetailBinding, DetailViewModel> {
    private LoginEntity.ItemsEntity entity;

    @Override
    public void initParam() {
        //获取列表传入的实体
        Bundle mBundle = getArguments();
        if (mBundle != null)
            entity = mBundle.getParcelable("entity");
    }

    @Override
    public int initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return R.layout.fragment_detail;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        viewModel.setDemoEntity(entity);
    }
}

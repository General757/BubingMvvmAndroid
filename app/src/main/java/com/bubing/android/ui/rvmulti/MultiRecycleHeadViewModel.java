package com.bubing.android.ui.rvmulti;

import androidx.annotation.NonNull;

import com.bubing.mvvm.base.BaseViewModel;
import com.bubing.mvvm.base.MultiItemViewModel;
import com.bubing.mvvm.binding.command.BindingAction;
import com.bubing.mvvm.binding.command.BindingCommand;
import com.bubing.mvvm.utils.ToastUtils;

/**
 * @ClassName: MultiRecycleHeadViewModel
 * @Description: java类作用描述
 * @Author: Bubing
 * @Date: 2020/8/4 1:15 PM
 */
public class MultiRecycleHeadViewModel extends MultiItemViewModel {

    public MultiRecycleHeadViewModel(@NonNull BaseViewModel viewModel) {
        super(viewModel);
    }

    //条目的点击事件
    public BindingCommand itemClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            ToastUtils.showShort("我是头布局");
        }
    });
}

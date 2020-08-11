package com.bubing.android.ui.rvmulti;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import com.bubing.mvvm.base.MultiItemViewModel;
import com.bubing.mvvm.binding.command.BindingAction;
import com.bubing.mvvm.binding.command.BindingCommand;
import com.bubing.mvvm.utils.ToastUtils;

/**
 * @ClassName: MultiRecycleLeftItemViewModel
 * @Description: java类作用描述
 * @Author: Bubing
 * @Date: 2020/8/4 1:17 PM
 */
public class MultiRecycleLeftItemViewModel extends MultiItemViewModel<MultiRecycleViewModel> {
    public ObservableField<String> text = new ObservableField<>("");

    public MultiRecycleLeftItemViewModel(@NonNull MultiRecycleViewModel viewModel, String text) {
        super(viewModel);
        this.text.set(text);
    }

    //条目的点击事件
    public BindingCommand itemClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            //拿到position
            int position = viewModel.observableList.indexOf(MultiRecycleLeftItemViewModel.this);
            ToastUtils.showShort("position：" + position);
        }
    });
}

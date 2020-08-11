package com.bubing.mvvm.binding.viewadapter.checkbox;

import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.databinding.BindingAdapter;

import com.bubing.mvvm.binding.command.BindingCommand;

/**
 * @ClassName: ViewAdapter
 * @Description: java类作用描述
 * @Author: Bubing
 * @Date: 2020/8/3 6:27 PM
 */
public class ViewAdapter {
    /**
     * @param bindingCommand //绑定监听
     */
    @SuppressWarnings("unchecked")
    @BindingAdapter(value = {"onCheckedChangedCommand"}, requireAll = false)
    public static void setCheckedChanged(final CheckBox checkBox, final BindingCommand<Boolean> bindingCommand) {
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                bindingCommand.execute(b);
            }
        });
    }
}

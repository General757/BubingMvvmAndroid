package com.bubing.mvvm.binding.command;

/**
 * @ClassName: BindingFunction
 * @Description: java类作用描述
 * @Author: Bubing
 * @Date: 2020/8/3 3:11 PM
 */
public interface BindingFunction<T> {
    T call();
}

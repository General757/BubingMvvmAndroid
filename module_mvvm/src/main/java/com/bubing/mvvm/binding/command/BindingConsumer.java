package com.bubing.mvvm.binding.command;

/**
 * @ClassName: BindingConsumer
 * @Description: java类作用描述
 * @Author: Bubing
 * @Date: 2020/8/3 11:06 AM
 */
public interface BindingConsumer<T> {
    void call(T t);
}

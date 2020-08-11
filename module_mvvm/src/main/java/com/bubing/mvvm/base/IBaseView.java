package com.bubing.mvvm.base;

/**
 * @ClassName: IBaseView
 * @Description: 初始化接口
 * @Author: Bubing
 * @Date: 2020/8/1 5:02 PM
 */
public interface IBaseView {
    //初始化界面传递参数
    void initParam();

    //初始化数据
    void initData();

    //初始化界面观察者的监听
    void initViewObservable();
}

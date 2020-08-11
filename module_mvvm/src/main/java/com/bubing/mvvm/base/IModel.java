package com.bubing.mvvm.base;

/**
 * @ClassName: IModel
 * @Description: Model接口
 * @Author: Bubing
 * @Date: 2020/8/1 5:20 PM
 */
public interface IModel {
    /**
     * ViewModel销毁时清除Model，与ViewModel共消亡
     * Model层同样不能长期持有生命周期对象
     */
    void onCleared();
}

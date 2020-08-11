package com.bubing.mvvm.binding.viewadapter.spinner;

/**
 * @ClassName: IKeyAndValue
 * @Description: 下拉Spinner控件的键值对, 实现该接口,返回key,value值, 在xml绑定List<IKeyAndValue>
 * @Author: Bubing
 * @Date: 2020/8/4 10:35 AM
 */
public interface IKeyAndValue {
    String getKey();

    String getValue();
}

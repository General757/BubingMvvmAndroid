package com.bubing.android.data.source;

/**
 * @ClassName: LocalDataSource
 * @Description: java类作用描述
 * @Author: Bubing
 * @Date: 2020/8/3 2:54 PM
 */
public interface LocalDataSource {
    /**
     * 保存用户名
     */
    void saveUserName(String userName);

    /**
     * 保存用户密码
     */

    void savePassword(String password);

    /**
     * 获取用户名
     */
    String getUserName();

    /**
     * 获取用户密码
     */
    String getPassword();
}

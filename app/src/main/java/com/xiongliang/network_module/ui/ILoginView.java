package com.xiongliang.network_module.ui;


import com.xiongliang.network_module.base.IBaseView;

public interface ILoginView extends IBaseView {
    /**
     * 登录成功
     */
    void loginSuccess();

    /**
     * 登录失败
     */
    void loginFailed();
}

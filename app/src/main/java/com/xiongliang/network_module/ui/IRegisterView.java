package com.xiongliang.network_module.ui;

import com.xiongliang.network_module.base.IBaseView;

public interface IRegisterView extends IBaseView {
    /**
     * 注册成功
     */
    void registerSuccess();

    /**
     * 注册失败
     */
    void registerFailed();
}

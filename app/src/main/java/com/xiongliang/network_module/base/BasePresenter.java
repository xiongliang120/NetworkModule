package com.xiongliang.network_module.base;

import com.xiongliang.network_module.ui.MainContract;


/***
 * 抽象类可以选择性实现接口方法
 */
public abstract class BasePresenter implements MainContract.IPresenter {
    public  MainContract.IView view;
    @Override
    public void attachView(MainContract.IView iView) {
          this.view = iView;
    }

    @Override
    public void detachView(MainContract.IView iView) {
        this.view = null;
    }
}

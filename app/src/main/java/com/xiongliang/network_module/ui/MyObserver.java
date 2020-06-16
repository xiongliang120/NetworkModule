package com.xiongliang.network_module.ui;

import com.xiongliang.network_module.base.BaseObserver;

import io.reactivex.disposables.Disposable;

public abstract class MyObserver<T> extends BaseObserver<T> {
    @Override
    public void onSubscribe(Disposable d) {
        super.onSubscribe(d);
        //TODO 网络请求时，显示加载框
    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
    }
}

package com.xiongliang.network_module.ui;

import android.app.Application;
import android.widget.Toast;

import com.xiongliang.network_module.app.BaseApplication;
import com.xiongliang.network_module.base.BaseObserver;
import com.xiongliang.network_module.base.BaseResponse;

import io.reactivex.disposables.Disposable;

public abstract class MyObserver<T> extends BaseObserver<T> {
    
    @Override
    public void onSubscribe(Disposable d) {
        super.onSubscribe(d);
        //TODO 网络请求时，显示加载框
        Toast.makeText(BaseApplication.getInstance(), "显示网络请求加载框", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
        Toast.makeText(BaseApplication.getInstance(), "隐藏网络请求加载框", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNext(BaseResponse<T> tBaseResponse) {
        super.onNext(tBaseResponse);
        //TODO  取消加载框
        Toast.makeText(BaseApplication.getInstance(), "隐藏网络请求加载框", Toast.LENGTH_SHORT).show();
    }
}

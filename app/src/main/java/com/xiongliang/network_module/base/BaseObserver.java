package com.xiongliang.network_module.base;

import android.util.Log;

import com.xiongliang.network_module.utils.ExceptionUtil;

import io.reactivex.disposables.Disposable;
import io.reactivex.Observer;

public abstract class BaseObserver<T> implements Observer<BaseResponse<T>> {
    @Override
    public void onComplete() {
    }

    @Override
    public void onError(Throwable e) {
        onFailure(e, ExceptionUtil.exceptionHandler(e));
    }

    @Override
    public void onNext(BaseResponse<T> tBaseResponse) {
        if(tBaseResponse.getErrno() == 0 || tBaseResponse.getErrno() == 200){
             onSuccess(tBaseResponse.getData());
        }else{
            onFailure(null,tBaseResponse.getDesc());
        }
    }

    @Override
    public void onSubscribe(Disposable d) {
    }

    public abstract void onSuccess(T result);

    public abstract void onFailure(Throwable e,String errorMsg);


}

package com.xiongliang.network_module.base;

import com.xiongliang.network_module.utils.ExceptionUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver implements Observer<BaseResponse> {
    @Override
    public void onComplete() {
    }

    @Override
    public void onError(Throwable e) {
        onFailure(e, ExceptionUtil.exceptionHandler(e));
    }

    @Override
    public void onNext(BaseResponse baseResponse) {
        if(baseResponse.getErrno() == 200){
             onSuccess(baseResponse.data);
        }else{
            onFailure(null,baseResponse.getDesc());
        }
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    public abstract void onSuccess(String result);

    public abstract void onFailure(Throwable e,String errorMsg);
}

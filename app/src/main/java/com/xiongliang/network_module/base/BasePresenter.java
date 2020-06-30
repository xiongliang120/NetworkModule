package com.xiongliang.network_module.base;

import com.xiongliang.network_module.ui.MainContract;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


/***
 * 抽象类可以选择性实现接口方法
 */
public abstract class BasePresenter<T extends MainContract.IView> implements MainContract.IPresenter<T> {
    protected  T view;

    //管理 Disposable,用于取消网络请求
    private CompositeDisposable mDisposables = new CompositeDisposable();

    @Override
    public void attachView(T iView) {
          this.view = iView;
    }

    @Override
    public void detachView(T iView) {
        this.view = null;
        dispond();
    }

    /***
     * 将subscribe 返回的Disposable 加入管理器
     */
    protected void add(Disposable disposable){
        mDisposables.add(disposable);
    }

    /**
     * UI 销毁时清空订阅对象
     */
    protected void dispond(){
        mDisposables.clear();
    }
}

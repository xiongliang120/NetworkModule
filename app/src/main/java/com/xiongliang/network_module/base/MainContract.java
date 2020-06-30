package com.xiongliang.network_module.base;

public interface MainContract {
    interface IPresenter<T extends IView>{
          void attachView(T view);
          void detachView(T view);
          void loadData();
    }

    interface IView{

    }
}

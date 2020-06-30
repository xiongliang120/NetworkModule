package com.xiongliang.network_module.ui;


import com.xiongliang.network_module.bean.response.WeatherItem;

import java.util.List;

public interface MainContract {
    interface IPresenter<T extends IView>{
          void attachView(T view);
          void detachView(T view);
          void loadData();
    }

    interface IView{

    }
}

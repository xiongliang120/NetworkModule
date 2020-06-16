package com.xiongliang.network_module.ui;


import com.xiongliang.network_module.bean.response.WeatherItem;

import java.util.List;

public interface MainContract {
    interface IPresenter{
          void attachView(IView view);
          void detachView(IView view);
          void loadWeatherData();
    }

    interface IView{
         void loadWeatherDataSuccess(List<WeatherItem> result);

         void loadWeatherDataFailed();
    }
}

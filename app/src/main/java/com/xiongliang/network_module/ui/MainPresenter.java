package com.xiongliang.network_module.ui;

import com.xiongliang.network_module.bean.response.WeatherItem;
import com.xiongliang.network_module.utils.RequestUtils;

import java.util.List;

public class MainPresenter implements MainContract.IPresenter {
    private MainContract.IView view;

    @Override
    public void attachView(MainContract.IView view) {
       this.view = view;
    }

    @Override
    public void detachView(MainContract.IView view) {
       this.view = null;
    }

    @Override
    public void loadWeatherData() {
        RequestUtils.getWeatherData(new MyObserver<WeatherItem>(){
            @Override
            public void onSuccess(List<WeatherItem> result) {
                view.loadWeatherDataSuccess(result);
            }

            @Override
            public void onFailure(Throwable e, String errorMsg) {
                view.loadWeatherDataFailed();
            }
        });
    }
}

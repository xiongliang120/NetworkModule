package com.xiongliang.network_module.ui;

import com.xiongliang.network_module.base.BasePresenter;
import com.xiongliang.network_module.bean.response.WeatherItem;
import com.xiongliang.network_module.utils.RequestUtils;

import java.util.List;

public class MainPresenter extends BasePresenter {
    @Override
    public void loadData() {
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

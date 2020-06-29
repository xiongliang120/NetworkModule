package com.xiongliang.network_module.ui;

import com.xiongliang.network_module.base.BasePresenter;
import com.xiongliang.network_module.base.BaseResponse;
import com.xiongliang.network_module.bean.response.WeatherItem;
import com.xiongliang.network_module.utils.RetrofitUtils;
import com.xiongliang.network_module.utils.RxHelper;


import io.reactivex.functions.Consumer;

public class MainActivityPresenter extends BasePresenter {
    private static String key = "9a3d2b174cb37033a7a6e0570bc8e265";

    @Override
    public void loadData() {
        add(RetrofitUtils.getApiUrl()
                .getWeather(key).compose(RxHelper.io_main()).subscribe(new Consumer<BaseResponse<WeatherItem>>() {
                    @Override
                    public void accept(BaseResponse<WeatherItem> weatherItemBaseResponse) throws Exception {
                        view.loadWeatherDataSuccess(weatherItemBaseResponse.result);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.loadWeatherDataFailed();
                    }
                }));
    }

}

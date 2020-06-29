package com.xiongliang.network_module;

import com.xiongliang.network_module.base.BaseResponse;
import com.xiongliang.network_module.bean.response.WeatherItem;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiUrl {
    /**
     *  免费天气地址    http://v.juhe.cn/ historyWeather/province?key=9a3d2b174cb37033a7a6e0570bc8e26
     * @param key
     * @return
     */
    @GET("historyWeather/province")
    Observable<BaseResponse<WeatherItem>> getWeather(@Query("key") String key);
}

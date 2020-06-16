package com.xiongliang.network_module;

import com.xiongliang.network_module.base.BaseResponse;
import com.xiongliang.network_module.bean.response.WeatherItem;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiUrl {

    @GET("historyWeather/province")
    Observable<BaseResponse<WeatherItem>> getWeather(@Query("key") String key);

//    @GET("historyWeather/province")
//    Call<BaseResponse<WeatherData>> getWeather(@Query("key") String key);
}

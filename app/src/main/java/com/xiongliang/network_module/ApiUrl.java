package com.xiongliang.network_module;

import com.xiongliang.network_module.bean.response.WeatherData;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiUrl {

    @GET("historyWeather/province")
    Observable<WeatherData> getWeather(@Query("key") String key);
//    @GET("news/item")
//    Observable<BaseResponse<ArticlesData>> postArticle(@Body RequestBody body);
}

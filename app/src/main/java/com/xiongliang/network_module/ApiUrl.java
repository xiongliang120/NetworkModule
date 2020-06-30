package com.xiongliang.network_module;

import com.xiongliang.network_module.base.BaseResponse;
import com.xiongliang.network_module.bean.response.CatCategory;
import com.xiongliang.network_module.bean.response.CatItem;
import com.xiongliang.network_module.bean.response.WeatherItem;

import java.util.List;

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

    /***
     *  Cat API  https://api.thecatapi.com/v1/sources?limit=10&page=0
     * @param limit,page
     * @return
     */
    @GET("v1/sources")
    Observable<List<CatItem>> getCat(@Query("limit") int limit, @Query("page") int page);

    /**
     * Cat API https://api.thecatapi.com/v1/categories
     * @return
     */
    @GET("v1/categories")
    Observable<List<CatCategory>> getCategories();


}

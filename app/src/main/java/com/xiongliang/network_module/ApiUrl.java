package com.xiongliang.network_module;

import com.xiongliang.network_module.bean.response.CatCategory;
import com.xiongliang.network_module.bean.response.CatItem;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiUrl {
    /***
     *  Cat API  https://api.thecatapi.com/v1/sources?limit=10&page=0
     * @param limit,page
     *   Cache-Control 是get请求支持的属性
     *   @Headers("Cache-Control: public,max-age:60"), 缓存有效时间60s
     *   @Headers("Cache-Control:public,no-cache"), 不缓存
     *   @Headers("Cache-Control:public,only-if-cached"), 只获取缓存数据,无数据则报504.
     *
     * @return
     */
//    @Headers("Cache-Control: public,max-age:60")
    @Headers("Cache-Control:public,no-cache")
//    @Headers("Cache-Control:public,only-if-cached")
    @GET("v1/sources")
    Flowable<List<CatItem>> getCat(@Query("limit") int limit, @Query("page") int page);

    /**
     * Cat API https://api.thecatapi.com/v1/categories
     * @return
     */
//    @Headers("Cache-Control: public,max-age:60")
    @Headers("Cache-Control:public,no-cache")
//    @Headers("Cache-Control:public,only-if-cached")
    @GET("v1/categories")
    Flowable<List<CatCategory>> getCategories();


}

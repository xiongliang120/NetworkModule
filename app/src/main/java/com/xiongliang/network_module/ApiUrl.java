package com.xiongliang.network_module;

import com.xiongliang.network_module.bean.response.CatCategory;
import com.xiongliang.network_module.bean.response.CatItem;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiUrl {
    /***
     *  Cat API  https://api.thecatapi.com/v1/sources?limit=10&page=0
     * @param limit,page
     * @return
     */
    @GET("v1/sources")
    Flowable<List<CatItem>> getCat(@Query("limit") int limit, @Query("page") int page);

    /**
     * Cat API https://api.thecatapi.com/v1/categories
     * @return
     */
    @GET("v1/categories")
    Flowable<List<CatCategory>> getCategories();


}

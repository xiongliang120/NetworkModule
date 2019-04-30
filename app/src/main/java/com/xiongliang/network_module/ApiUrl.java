package com.xiongliang.network_module;

import com.xiongliang.network_module.bean.response.ArticlesData;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiUrl {
    @POST("article/list")
    Observable<ArticlesData> postArticle(@Body RequestBody body);
}

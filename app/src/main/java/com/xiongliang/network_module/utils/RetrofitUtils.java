package com.xiongliang.network_module.utils;


import androidx.annotation.NonNull;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.xiongliang.network_module.ApiUrl;
import com.xiongliang.network_module.app.BaseApplication;
import com.xiongliang.network_module.base.Constans;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    private static volatile ApiUrl mApiUrl;

    private RetrofitUtils(){

    }

    /**
     * 饿汉单例模式
     */
    public static ApiUrl getApiUrl() {
        if (mApiUrl == null) {
            synchronized (RetrofitUtils.class) {
                if (mApiUrl == null) {
                    mApiUrl = new RetrofitUtils().getRetrofit();
                }
            }
        }
        return mApiUrl;
    }

    public ApiUrl getRetrofit() {
        // 初始化Retrofit
        ApiUrl apiUrl = initRetrofit(initOkHttp()) .create(ApiUrl.class);
        return apiUrl;
    }


    /**
     * 初始化okhttp
     */
    @NonNull
    private OkHttpClient initOkHttp() {
        //缓存文件夹
        File cacheFile = new File(BaseApplication.getInstance().getExternalCacheDir().toString(),"cache");
        //缓存大小为10M
        int cacheSize = 10 * 1024 * 1024;
        //创建缓存对象
        Cache cache = new Cache(cacheFile,cacheSize);

        return new OkHttpClient().newBuilder()
                .readTimeout(Constans.DEFAULT_TIME, TimeUnit.SECONDS)//设置读取超时时间
                .connectTimeout(Constans.DEFAULT_TIME, TimeUnit.SECONDS)//设置请求超时时间
                .writeTimeout(Constans.DEFAULT_TIME,TimeUnit.SECONDS)//设置写入超时时间
                .addInterceptor(new LogInterceptor())//添加打印拦截器
                .addNetworkInterceptor(new CacheInterceptor())
                .cache(cache)
                .retryOnConnectionFailure(true)//设置出现错误进行重新连接。
                .build();
    }

    /**
     * 初始化Retrofit
     */
    @NonNull
    private Retrofit initRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(Constans.BaseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}

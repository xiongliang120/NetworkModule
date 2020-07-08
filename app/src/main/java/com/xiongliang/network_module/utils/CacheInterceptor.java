package com.xiongliang.network_module.utils;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class CacheInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response originalResponse = chain.proceed(request);
        //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
        String cacheControl = request.cacheControl().toString();
        Log.i("xiongliang","打印CacheControl="+cacheControl);

        return originalResponse.newBuilder()
                .header("Cache-Control", cacheControl)
                .removeHeader("Pragma")
                .build();

    }
}

package com.xiongliang.network_module.utils;

import android.util.Log;

import java.io.IOException;
import java.util.Locale;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * 打印拦截器
 */
public class LogInterceptor implements Interceptor {
    private String TAG = "okhttp";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long t1 = System.nanoTime();
        Response response = chain.proceed(request);
        long t2 = System.nanoTime();
        Log.i(TAG,String.format(Locale.getDefault(), "Received response for %s in %.1fms%n%s",
                response.request().url(), (t2 - t1) / 1e6d, response.headers()));
        MediaType mediaType = response.body().contentType();
        Log.i(TAG,"mediaType:"+mediaType);
        String content = response.body().string();
        Log.i(TAG,"response body:"+content);
        return response.newBuilder().body(ResponseBody.create(mediaType,content)).build();
    }
}

package com.xiongliang.network_module.utils;

import android.util.Log;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

import static okhttp3.internal.Util.UTF_8;

/**
 * 打印拦截器
 */
public class LogInterceptor implements Interceptor {
    private String TAG = "okhttp";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Log.i(TAG,"request url:"+request.url());
        long t1 = System.nanoTime();
        printParams(request.body());
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


    private void printParams(RequestBody body) {
        if(body == null){
            return;
        }
        Buffer buffer = new Buffer();
        try {
            body.writeTo(buffer);
            Charset charset = Charset.forName("UTF-8");
            MediaType contentType = body.contentType();
            if (contentType != null) {
                charset = contentType.charset(UTF_8);
            }
            String params = buffer.readString(charset);
            Log.i(TAG,"请求参数：|"+params);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

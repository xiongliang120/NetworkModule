package com.xiongliang.network_module.utils;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonDeserializer;
import com.trello.rxlifecycle2.components.RxActivity;
import com.xiongliang.network_module.MyObserver;
import com.xiongliang.network_module.bean.request.ArticleParams;

import org.json.JSONObject;

import java.util.Iterator;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Callback;

public class RequestUtils {

    private static String key = "9a3d2b174cb37033a7a6e0570bc8e265";


    /**
     * Post 请求article
     * @param context
     * @param observer
     */
    public static void getDemo(RxActivity context, MyObserver observer){
        RetrofitUtils.getApiUrl()
                .getWeather(key).compose(RxHelper.flowableIO2Main()).subscribe(observer);
    }

    //免费天气地址     http://v.juhe.cn/historyWeather/province?key=9a3d2b174cb37033a7a6e0570bc8e26
}

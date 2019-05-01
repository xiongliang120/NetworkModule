package com.xiongliang.network_module.utils;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonDeserializer;
import com.trello.rxlifecycle2.components.RxActivity;
import com.xiongliang.network_module.MyObserver;
import com.xiongliang.network_module.bean.request.ArticleParams;

import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class RequestUtils {

    /**
     * Post 请求article
     * @param context
     * @param observer
     */
    public static void getDemo(ArticleParams articleParams, RxActivity context, MyObserver observer){
        String bodyStr = JSON.toJSONString(articleParams);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), bodyStr);
        RetrofitUtils.getApiUrl()
                .postArticle(body).compose(RxHelper.observableIO2Main(context)).subscribe(observer);
    }


}

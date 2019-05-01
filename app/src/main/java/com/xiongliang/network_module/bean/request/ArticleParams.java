package com.xiongliang.network_module.bean.request;



import com.xiongliang.network_module.base.BaseParams;

import java.util.HashMap;

public class ArticleParams extends BaseParams {
    private ArticlePage data;

    public ArticlePage getData() {
        return data;
    }

    public void setData(ArticlePage data) {
        this.data = data;
    }

    //    private HashMap<String, Object> data;
//
//
//    /**
//     * 添加请求参数
//     *
//     * @param key
//     * @param obj
//     */
//    public void addParam(String key, Object obj) {
//        if (data == null) {
//            data = new HashMap<>();
//        }
//        data.put(key, obj);
//    }

//    @Override
//    public String toString() {
//        //return JsonUtils.toJSONString(mBaseParams);
//    }
}

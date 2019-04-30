package com.xiongliang.network_module.bean.request;



import com.xiongliang.network_module.base.BaseParams;

import java.util.HashMap;

public class ArticleParams extends BaseParams {
    /**
     * 基本参数
     */
    public BaseParams mBaseParams;

    /**
     * 参数键值对
     */
    private HashMap<String, Object> mapData;

    public ArticleParams() {
        mBaseParams = BaseParams.newParams();
    }

    private ArticleParams(Object object) {
        mBaseParams = BaseParams.newParams(object);
    }

    public static ArticleParams get() {
        return new ArticleParams();
    }

    public static ArticleParams get(Object object) {
        return new ArticleParams(object);
    }

    /**
     * 添加请求参数
     *
     * @param key
     * @param obj
     */
    public ArticleParams addParam(String key, Object obj) {
        if (mapData == null) {
            mapData = new HashMap<>();
            mBaseParams.data = mapData;
        }
        mapData.put(key, obj);
        return this;
    }





}

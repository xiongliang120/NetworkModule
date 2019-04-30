package com.xiongliang.network_module.base;

import android.os.Build;


public class BaseParams {
    /**
     * 终端类型
     * 0=Android
     * 1=iOS
     */
    public int term = 0;

    /**
     * 当前版本
     * 只初始化一次
     */
    public int version = 125;

    /**
     * 设备ID
     */
    public String udid = "583757b8563c1791ca4eeadc965ed3e1";

    /**
     * 手机型号
     */
    public String model = Build.MODEL;

    /**
     * 包名
     */
    public String app = "com.xiongliang.network_module";

    /**
     * 时间戳
     */
    public long ts = System.currentTimeMillis();

    /**
     * 数据体
     */
    public Object data;

    public BaseParams() {

    }

    private BaseParams(Object object) {
        this.data = object;
    }

    public static BaseParams newParams() {
        return new BaseParams();
    }

    public static BaseParams newParams(Object object) {
        return new BaseParams(object);
    }

}

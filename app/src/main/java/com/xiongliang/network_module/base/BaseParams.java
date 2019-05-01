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

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }
}

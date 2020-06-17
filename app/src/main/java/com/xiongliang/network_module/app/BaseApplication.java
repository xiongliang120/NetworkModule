package com.xiongliang.network_module.app;

import android.app.Application;

public class BaseApplication extends Application {
    public static Application mApplication;

    public static Application getInstance(){
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.mApplication = this;
    }
}

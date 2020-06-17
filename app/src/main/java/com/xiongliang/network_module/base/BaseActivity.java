package com.xiongliang.network_module.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.RxActivity;

public abstract class BaseActivity extends RxActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        initView();
        initEvent();
        initData();
    }

     public abstract int getLayoutResID();

     public abstract void initView();

     public abstract void initEvent();

     public abstract void initData();
}

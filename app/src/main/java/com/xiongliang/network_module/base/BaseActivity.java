package com.xiongliang.network_module.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.RxActivity;

public abstract class BaseActivity extends RxActivity {
    public BasePresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        mPresenter = attachPresenter();
        attachView();
        initView();
        initEvent();
        initData();
    }
    public abstract BasePresenter attachPresenter();

    public abstract void attachView();

    public abstract int getLayoutResID();

    public abstract void initView();

    public abstract void initEvent();

    public abstract void initData();
}

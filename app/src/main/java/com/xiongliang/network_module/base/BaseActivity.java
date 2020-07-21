package com.xiongliang.network_module.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;


public abstract class BaseActivity<P> extends FragmentActivity {
    protected P mPresenter;

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
    protected abstract P attachPresenter();

    protected abstract void attachView();

    protected abstract int getLayoutResID();

    protected abstract void initView();

    protected abstract void initEvent();

    protected abstract void initData();
}

package com.xiongliang.network_module.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

public abstract class BaseFragment extends Fragment {
    public BasePresenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = attachPresenter();
        initView();
        initEvent();
        initData();
    }


    protected abstract BasePresenter attachPresenter();

    protected abstract void attachView();

    protected abstract void initView();

    protected abstract void initEvent();

    protected abstract void initData();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}

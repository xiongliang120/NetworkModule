package com.xiongliang.network_module.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.xiongliang.network_module.proxy.MvpProxy;


public abstract class BaseActivity extends FragmentActivity {
    protected MvpProxy mvpProxy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        mvpProxy = createProxy();
        addPresenter();
        initView();
        initEvent();
        initData();
    }

    public MvpProxy createProxy(){
        if(mvpProxy == null){
            mvpProxy = new MvpProxy((MainContract.IView)this);
        }
        return mvpProxy;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mvpProxy != null){
            mvpProxy.unBindPresenter();
        }
    }

    protected abstract void addPresenter();

    protected abstract int getLayoutResID();

    protected abstract void initView();

    protected abstract void initEvent();

    protected abstract void initData();
}

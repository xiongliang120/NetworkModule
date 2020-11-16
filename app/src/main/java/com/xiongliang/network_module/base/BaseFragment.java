package com.xiongliang.network_module.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.xiongliang.network_module.proxy.MvpProxy;


public abstract class BaseFragment extends Fragment {
    protected MvpProxy mvpProxy;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createProxy();
        addPresenter();
        initView();
        initEvent();
        initData();
    }


    public MvpProxy createProxy(){
        if(mvpProxy == null){
            mvpProxy = new MvpProxy((IBaseView) this);
        }
        return mvpProxy;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mvpProxy != null){
            mvpProxy.unBindPresenter();
        }
    }

    protected abstract void addPresenter();

    protected abstract void initView();

    protected abstract void initEvent();

    protected abstract void initData();

}

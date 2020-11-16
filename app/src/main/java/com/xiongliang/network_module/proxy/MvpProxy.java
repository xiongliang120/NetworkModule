package com.xiongliang.network_module.proxy;

import com.xiongliang.network_module.base.BasePresenter;
import com.xiongliang.network_module.base.MainContract;

import java.util.ArrayList;
import java.util.List;

public class MvpProxy<V extends MainContract.IView> {
    private List<BasePresenter> mList;
    protected  V view;

    public MvpProxy(V iview){
        mList = new ArrayList<>();
        this.view = iview;
    }

    public void bindPresenter(BasePresenter basePresenter){
        basePresenter.attachView(view);
        mList.add(basePresenter);
    }

    public void unBindPresenter(){
        for (int i = 0; i < mList.size() ; i++) {
            mList.get(i).detachView();
        }
        mList.clear();
        mList = null;

    }
}

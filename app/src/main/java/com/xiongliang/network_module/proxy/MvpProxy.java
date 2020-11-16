package com.xiongliang.network_module.proxy;

import com.xiongliang.network_module.base.BasePresenter;
import com.xiongliang.network_module.base.IBaseView;

import java.util.ArrayList;
import java.util.List;

/***
 * MvpProxy 保存List<BasePresenter>
 * bindPresenter(View iView),将Presenter 保存到集合中,并将View 保存到Presenter中.
 * unBindPresenter(), 将Presenter 从集合取出分别detach
 *
 * Presenter 保存 IView, 用于回调给View
 *
 *
 * @param <V>
 */

public class MvpProxy<V extends IBaseView> {
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

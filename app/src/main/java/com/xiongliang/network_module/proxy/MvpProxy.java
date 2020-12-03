package com.xiongliang.network_module.proxy;

import com.xiongliang.network_module.base.BasePresenter;
import com.xiongliang.network_module.base.IBaseView;

import java.util.ArrayList;
import java.util.List;

/***
 * MvpProxy 保存List<BasePresenter>
 * bindPresenter(BasePresenter basePresenter),将View 保存到Presenter中, 并将Presenter 保存到集合中.
 * unBindPresenter(), 将Presenter 从集合取出分别detach,最后全部移除
 *
 * Presenter 保存 IView, 用于回调给View, 每个Presenter对应一个IView接口
 *
 * 场景：
 * 文章点赞、文章收藏、关注接口,很多页面会用到, VP 一对一会导致每个P都需要重复定义一遍.
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

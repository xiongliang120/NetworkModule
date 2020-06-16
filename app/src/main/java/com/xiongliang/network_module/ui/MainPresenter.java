package com.xiongliang.network_module.ui;

import com.xiongliang.network_module.MyObserver;
import com.xiongliang.network_module.bean.request.ArticlePage;
import com.xiongliang.network_module.bean.request.ArticleParams;
import com.xiongliang.network_module.bean.response.WeatherData;
import com.xiongliang.network_module.utils.RequestUtils;

public class MainPresenter implements MainContract.IPresenter {
    private MainContract.IView view;

    @Override
    public void attachView(MainContract.IView view) {
       this.view = view;
    }

    @Override
    public void detachView(MainContract.IView view) {

    }

    @Override
    public void loadData() {
        RequestUtils.getDemo(new MyObserver<WeatherData>(){
            @Override
            public void onSuccess(WeatherData result) {
                view.loadArticleSuccess();
            }

            @Override
            public void onFailure(Throwable e, String errorMsg) {
                view.loadArticleFailed();
            }
        });
    }
}

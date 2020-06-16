package com.xiongliang.network_module.ui;

public interface MainContract {
    interface IPresenter{
          void attachView(IView view);
          void detachView(IView view);
          void loadData();
    }

    interface IView{
         void loadArticleSuccess();

         void loadArticleFailed();
    }
}

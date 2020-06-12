package com.xiongliang.network_module.ui;

public interface MainContract {
    interface IPresenter{
         public void loadData();
    }

    interface IView{
        public void loadArticleSuccess();
        
        public void loadArticleFailed();
    }
}

package com.xiongliang.network_module.ui;

import android.widget.Toast;

import com.xiongliang.network_module.MyObserver;
import com.xiongliang.network_module.bean.request.ArticlePage;
import com.xiongliang.network_module.bean.request.ArticleParams;
import com.xiongliang.network_module.bean.response.ArticlesData;
import com.xiongliang.network_module.utils.RequestUtils;

public class MainPresenter implements MainContract.IPresenter {
    @Override
    public void loadData() {
        ArticleParams articleParams = new ArticleParams();
        ArticlePage articlePage = new ArticlePage();
        articlePage.setPage_num(1);
        articlePage.setPage_size(10);
        articleParams.setData(articlePage);

//        RequestUtils.getDemo(articleParams,this,new MyObserver<ArticlesData>(){
//            @Override
//            public void onSuccess(ArticlesData result) {
//                Toast.makeText(MainActivity.this,"请求数据成功",Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onFailure(Throwable e, String errorMsg) {
//                Toast.makeText(MainActivity.this,"请求数据失败",Toast.LENGTH_LONG).show();
//            }
//        });
    }
}

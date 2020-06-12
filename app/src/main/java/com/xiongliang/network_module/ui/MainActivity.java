package com.xiongliang.network_module.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.trello.rxlifecycle2.components.RxActivity;
import com.xiongliang.network_module.MyObserver;
import com.xiongliang.network_module.R;
import com.xiongliang.network_module.bean.request.ArticlePage;
import com.xiongliang.network_module.bean.request.ArticleParams;
import com.xiongliang.network_module.bean.response.ArticlesData;
import com.xiongliang.network_module.utils.RequestUtils;

public class MainActivity extends RxActivity {
    private Button articleButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        articleButton = findViewById(R.id.articleButton);
        articleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getArticleData();
            }
        });
    }

    public void getArticleData(){
        ArticleParams articleParams = new ArticleParams();
        ArticlePage articlePage = new ArticlePage();
        articlePage.setPage_num(1);
        articlePage.setPage_size(10);
        articleParams.setData(articlePage);

        RequestUtils.getDemo(articleParams,this,new MyObserver<ArticlesData>(){
            @Override
            public void onSuccess(ArticlesData result) {
                Toast.makeText(MainActivity.this,"请求数据成功",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Throwable e, String errorMsg) {
                Toast.makeText(MainActivity.this,"请求数据失败",Toast.LENGTH_LONG).show();
            }
        });
    }
}

package com.xiongliang.network_module;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.trello.rxlifecycle2.components.RxActivity;
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
        articleParams.addParam("page_num",  1);
        articleParams.addParam("page_size", 10);
        RequestUtils.getDemo(articleParams,this,new MyObserver(){
            @Override
            public void onSuccess(String result) {
                super.onSuccess(result);
            }

            @Override
            public void onFailure(Throwable e, String errorMsg) {
                super.onFailure(e, errorMsg);
            }
        });
    }
}

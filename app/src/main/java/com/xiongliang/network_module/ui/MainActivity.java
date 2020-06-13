package com.xiongliang.network_module.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.trello.rxlifecycle2.components.RxActivity;
import com.xiongliang.network_module.R;

public class MainActivity extends RxActivity implements MainContract.IView {
    private Button articleButton;
    private MainPresenter mainPresenter;

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
        mainPresenter = new MainPresenter();
        mainPresenter.loadData();
    }

    @Override
    public void loadArticleSuccess() {

    }

    @Override
    public void loadArticleFailed() {

    }
}

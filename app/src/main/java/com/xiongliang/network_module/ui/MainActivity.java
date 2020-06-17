package com.xiongliang.network_module.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.trello.rxlifecycle2.components.RxActivity;
import com.xiongliang.network_module.R;
import com.xiongliang.network_module.base.BaseActivity;
import com.xiongliang.network_module.bean.response.WeatherItem;

import java.util.List;

public class MainActivity extends BaseActivity implements MainContract.IView {
    private Button articleButton;
    private MainPresenter mainPresenter;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

    @Override
    public void initView() {
        articleButton = findViewById(R.id.articleButton);
    }

    @Override
    public void initEvent() {
        articleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWeatherData();
            }
        });
    }

    @Override
    public void initData() {

    }

    public void getWeatherData(){
        mainPresenter = new MainPresenter();
        mainPresenter.attachView(this);
        mainPresenter.loadData();
    }


    @Override
    public void loadWeatherDataSuccess(List<WeatherItem> result) {
        Log.i("xiongliang"," 获取数据成功"+result.size());
    }

    @Override
    public void loadWeatherDataFailed() {
        Log.i("xiongliang"," 获取数据失败");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mainPresenter != null){
            mainPresenter.detachView(this);
            mainPresenter = null;
        }
    }
}

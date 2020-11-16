package com.xiongliang.network_module.ui;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.xiongliang.network_module.R;
import com.xiongliang.network_module.base.BaseActivity;
import com.xiongliang.network_module.base.MainContract;
import com.xiongliang.network_module.bean.response.CatItem;

import java.util.List;

public class MainActivity extends BaseActivity implements MainContract.IView {
    private Button articleButton;

    private MainFragment mainFragment;

    private MainActivityPresenter mainActivityPresenter;

    private SecondActivityPresenter secondActivityPresenter;


    @Override
    protected void addPresenter() {
        mainActivityPresenter = new MainActivityPresenter();
        secondActivityPresenter = new SecondActivityPresenter();
        mvpProxy.bindPresenter(mainActivityPresenter);
        mvpProxy.bindPresenter(secondActivityPresenter);
    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        articleButton = findViewById(R.id.articleButton);

        mainFragment = new MainFragment();
        FragmentManager fragmentManager  = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,mainFragment);
        fragmentTransaction.commit();

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
        getWeatherData();
        getCountryData();
    }

    /**
     * 获取天气数据
     */
    public void getWeatherData(){
        if(mainActivityPresenter != null){
            mainActivityPresenter.loadData();
        }
    }

    /***
     * 获取城市数据
     */
    public void getCountryData(){
        if(secondActivityPresenter != null){
            secondActivityPresenter.loadData();
        }
    }



    @Override
    public void loadDataSuccess() {
        Log.i("xiongliang","Activity  获取数据成功");
    }

    public void loadDataFailed() {
        Log.i("xiongliang","Activity  获取数据失败");
    }
}

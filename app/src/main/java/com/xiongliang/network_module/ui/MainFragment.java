package com.xiongliang.network_module.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.xiongliang.network_module.R;
import com.xiongliang.network_module.base.BaseFragment;
import com.xiongliang.network_module.base.MainContract;

public class MainFragment extends BaseFragment implements MainContract.IView {
    private MainFragmentPresenter mainFragmentPresenter;
    private SencondFragmentPresenter sencondFragmentPresenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_main,null);
        return fragmentView;
    }



    @Override
    protected void addPresenter() {
        mainFragmentPresenter = new MainFragmentPresenter();
        sencondFragmentPresenter = new SencondFragmentPresenter();
        mvpProxy.bindPresenter(mainFragmentPresenter);
        mvpProxy.bindPresenter(sencondFragmentPresenter);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {
        getFragmentWeatherData();
        getFragmentCountryData();
    }

    /**
     * 获取Fragment 天气数据
     */
    public void getFragmentWeatherData(){
        mainFragmentPresenter.loadData();
    }

    /***
     * 获取Fragment 城市数据
     */
    public void getFragmentCountryData(){
        sencondFragmentPresenter.loadData();
    }


    public void loadDataSuccess() {
        Log.i("xiongliang","Fragment 接收到接口返回数据");
    }

    public void loadDataFailed() {
        Log.i("xiongliang","Fragment 接收到接口返回数据失败");
    }
}

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

public class LoginFragment extends BaseFragment implements ILoginView,IRegisterView{
    private LoginFragmentPresenter mainFragmentPresenter;
    private RegisterFragmentPresenter sencondFragmentPresenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_main,null);
        return fragmentView;
    }



    @Override
    protected void addPresenter() {
        mainFragmentPresenter = new LoginFragmentPresenter();
        sencondFragmentPresenter = new RegisterFragmentPresenter();
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


    @Override
    public void loginSuccess() {
        Log.i("xiongliang","Fragment loginSuccess");
    }

    @Override
    public void loginFailed() {
        Log.i("xiongliang","Fragment loginFailed");
    }

    @Override
    public void registerSuccess() {
        Log.i("xiongliang","Fragment registerSuccess");
    }

    @Override
    public void registerFailed() {
        Log.i("xiongliang","Fragment registerFailed");
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void showToast(String toastText) {

    }
}

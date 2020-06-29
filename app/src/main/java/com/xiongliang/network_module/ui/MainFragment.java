package com.xiongliang.network_module.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiongliang.network_module.R;
import com.xiongliang.network_module.base.BaseFragment;
import com.xiongliang.network_module.base.BasePresenter;
import com.xiongliang.network_module.bean.response.WeatherItem;

import java.util.List;

public class MainFragment extends BaseFragment implements MainContract.IView {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_main,null);
        return fragmentView;
    }

    @Override
    protected BasePresenter attachPresenter() {
        return new MainFragmentPresenter();
    }

    @Override
    protected void attachView() {
       mPresenter.attachView(this);
    }

    @Override
    public void loadWeatherDataSuccess(List<WeatherItem> result) {
        Log.i("xiongliang","111");
    }

    @Override
    public void loadWeatherDataFailed() {
        Log.i("xiongliang","2222");
    }
}

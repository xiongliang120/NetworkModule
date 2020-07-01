package com.xiongliang.network_module.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiongliang.network_module.R;
import com.xiongliang.network_module.base.BaseFragment;
import com.xiongliang.network_module.base.MainContract;
import com.xiongliang.network_module.bean.response.CatCategory;

import java.util.List;

public class MainFragment extends BaseFragment<MainFragmentPresenter> implements MainContract.IView {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_main,null);
        return fragmentView;
    }

    @Override
    protected MainFragmentPresenter attachPresenter() {
        return new MainFragmentPresenter();
    }

    @Override
    protected void attachView() {
       mPresenter.attachView(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {
        mPresenter.loadData();
    }


    public void loadDataSuccess(List<CatCategory> result) {
        if(result != null){
            Log.i("xiongliang","Fragment 接收到接口返回数据"+result.size());
        }
    }

    public void loadDataFailed() {
        Log.i("xiongliang","Fragment 接收到接口返回数据失败");
    }
}

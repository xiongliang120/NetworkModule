package com.xiongliang.network_module.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.xiongliang.network_module.R;
import com.xiongliang.network_module.base.BaseActivity;
import com.xiongliang.network_module.base.BasePresenter;
import com.xiongliang.network_module.bean.response.WeatherItem;

import java.util.List;

public class MainActivity extends BaseActivity implements MainContract.IView {
    private Button articleButton;

    private MainFragment mainFragment;

    @Override
    public BasePresenter attachPresenter() {
        return new MainActivityPresenter();
    }

    @Override
    public void attachView() {
        mPresenter.attachView(this);
    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        articleButton = findViewById(R.id.articleButton);

        mainFragment = new MainFragment();
        FragmentManager fragmentManager  = getFragmentManager();
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
    }

    public void getWeatherData(){
        mPresenter.loadData();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter != null){
            mPresenter.detachView(this);
            mPresenter = null;
        }
    }

    @Override
    public void loadDataSuccess(List<WeatherItem> result) {
        if(result != null){
            Log.i("xiongliang"," 获取数据成功"+result.size());
        }
    }

    @Override
    public void loadDataFailed() {
        Log.i("xiongliang"," 获取数据失败");
    }
}

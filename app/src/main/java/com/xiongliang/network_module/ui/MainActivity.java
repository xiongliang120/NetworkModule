package com.xiongliang.network_module.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.xiongliang.network_module.R;
import com.xiongliang.network_module.base.BaseActivity;
import com.xiongliang.network_module.base.MainContract;
import com.xiongliang.network_module.bean.response.CatItem;

import java.util.List;

public class MainActivity extends BaseActivity<MainActivityPresenter> implements MainContract.IView {
    private Button articleButton;

    private MainFragment mainFragment;


    @Override
    protected MainActivityPresenter attachPresenter() {
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

    public void loadDataSuccess(List<CatItem> result) {
        if(result != null){
            Log.i("xiongliang","Activity 获取数据成功"+result.size());
        }
    }

    public void loadDataFailed() {
        Log.i("xiongliang","Activity  获取数据失败");
    }
}

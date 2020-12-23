package com.xiongliang.network_module.ui;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.xiongliang.network_module.R;
import com.xiongliang.network_module.base.BaseActivity;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;


public class LoginActivity extends BaseActivity implements ILoginView,IRegisterView {
    private Button articleButton;

    private LoginFragment mainFragment;

    private LoginActivityPresenter mainActivityPresenter;

    private RegisterActivityPresenter secondActivityPresenter;


    @Override
    protected void addPresenter() {
        mainActivityPresenter = new LoginActivityPresenter();
        secondActivityPresenter = new RegisterActivityPresenter();
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

        mainFragment = new LoginFragment();
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
     * 测试callable
     *
     * Future.get() 是堵塞的, 新的方式是 CompletableFuture 可以采用非堵塞的方式获取返回值
     *
     *
     */
    public void testCallable(){
        try{
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            Future<String> future1 = executorService.submit(new Callable<String>(){
                @Override
                public String call() throws Exception {
                    return "xiongliang";
                }
            });
            Log.i("xiongliang","打印线程池执行Callable 返回Future,获取call执行的返回值="+future1.get());
        }catch (Exception e){
            e.printStackTrace();
        }
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
    public void loginSuccess() {
        Log.i("xiongliang","Activity  loginSuccess");
    }

    @Override
    public void loginFailed() {
        Log.i("xiongliang","Activity  loginFailed");
    }

    @Override
    public void registerSuccess() {
        Log.i("xiongliang","Activity  registerSuccess");
    }

    @Override
    public void registerFailed() {
        Log.i("xiongliang","Activity  registerFailed");
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void showToast(String toastText) {

    }
}

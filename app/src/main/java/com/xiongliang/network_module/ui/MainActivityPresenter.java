package com.xiongliang.network_module.ui;

import android.util.Log;

import com.xiongliang.network_module.base.BasePresenter;
import com.xiongliang.network_module.bean.response.CatItem;
import com.xiongliang.network_module.utils.RetrofitUtils;
import com.xiongliang.network_module.utils.RxHelper;


import java.util.List;

import io.reactivex.functions.Consumer;

public class MainActivityPresenter extends BasePresenter<ILoginView> {

    public void loadData() {
        add(RetrofitUtils.getApiUrl()
                .getCat(10,0).compose(RxHelper.io_main()).subscribe(new Consumer<List<CatItem>>() {
                    @Override
                    public void accept(List<CatItem> catItems) throws Exception {
                        iView.loginSuccess();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iView.loginFailed();
                    }
                }));
    }

}

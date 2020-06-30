package com.xiongliang.network_module.ui;

import android.util.Log;

import com.xiongliang.network_module.base.BasePresenter;
import com.xiongliang.network_module.bean.response.CatItem;
import com.xiongliang.network_module.utils.RetrofitUtils;
import com.xiongliang.network_module.utils.RxHelper;


import java.util.List;

import io.reactivex.functions.Consumer;

public class MainActivityPresenter extends BasePresenter {
    @Override
    public void loadData() {
        add(RetrofitUtils.getApiUrl()
                .getCat(10,0).compose(RxHelper.io_main()).subscribe(new Consumer<List<CatItem>>() {
                    @Override
                    public void accept(List<CatItem> catItems) throws Exception {
                        Log.i("xiongliang","11111");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.i("xiongliang","222");
                    }
                }));
    }

}

package com.xiongliang.network_module.ui;


import com.xiongliang.network_module.base.BasePresenter;
import com.xiongliang.network_module.bean.response.CatCategory;
import com.xiongliang.network_module.utils.RetrofitUtils;
import com.xiongliang.network_module.utils.RxHelper;

import java.util.List;

import io.reactivex.functions.Consumer;

public class RegisterFragmentPresenter extends BasePresenter<IRegisterView> {

    public void loadData() {
        add(RetrofitUtils.getApiUrl()
                .getCategories().compose(RxHelper.io_main()).subscribe(new Consumer<List<CatCategory>>() {
                    @Override
                    public void accept(List<CatCategory> catCategories) throws Exception {
                         iView.registerSuccess();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iView.registerFailed();
                    }
                }));
    }
}

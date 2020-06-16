package com.xiongliang.network_module.utils;


import com.xiongliang.network_module.ui.MyObserver;


public class RequestUtils {

    private static String key = "9a3d2b174cb37033a7a6e0570bc8e265";


    /**
     * 免费天气地址     http://v.juhe.cn/historyWeather/province?key=9a3d2b174cb37033a7a6e0570bc8e26
     * Post 请求article
     * @param observer
     */
    public static void getWeatherData(MyObserver observer){
        RetrofitUtils.getApiUrl()
                .getWeather(key).compose(RxHelper.io_main()).subscribe(observer);


//        Call<BaseResponse<WeatherData>> call =  RetrofitUtils.getApiUrl().getWeather(key);
//        call.enqueue(new Callback<BaseResponse<WeatherData>>() {
//            @Override
//            public void onResponse(Call<BaseResponse<WeatherData>> call, Response<BaseResponse<WeatherData>> response) {
//                Log.i("xiongliang","成功");
//            }
//
//            @Override
//            public void onFailure(Call<BaseResponse<WeatherData>> call, Throwable t) {
//                Log.i("xiongliang","失败");
//            }
//        });
    }


}

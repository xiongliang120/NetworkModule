package com.xiongliang.network_module.utils;

import android.content.Context;

import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.RxActivity;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle2.components.support.RxFragment;
import com.trello.rxlifecycle2.components.support.RxFragmentActivity;

import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * RxJava 调度
 */
public class RxHelper {
//    public static <T> ObservableTransformer<T, T> observableIO2Main(final Context context) {
//        return upstream -> {
//            Observable<T> observable = upstream.subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread());
//            return composeContext(context, observable);
//        };
//    }
//
//    public static <T> ObservableTransformer<T, T> observableIO2Main(final RxFragment fragment) {
//        return upstream -> upstream.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread()).compose(fragment.<T>bindToLifecycle());
//    }
//
//    public static <T> FlowableTransformer<T, T> flowableIO2Main() {
//        return upstream -> upstream
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//    }
//
//    private static <T> ObservableSource<T> composeContext(Context context, Observable<T> observable) {
//        if(context instanceof RxActivity) {
//            return observable.compose(((RxActivity) context).bindUntilEvent(ActivityEvent.DESTROY));
//        } else if(context instanceof RxFragmentActivity){
//            return observable.compose(((RxFragmentActivity) context).bindUntilEvent(ActivityEvent.DESTROY));
//        }else if(context instanceof RxAppCompatActivity){
//            return observable.compose(((RxAppCompatActivity) context).bindUntilEvent(ActivityEvent.DESTROY));
//        }else {
//            return observable;
//        }
//    }

    final static ObservableTransformer Stf = new ObservableTransformer() {
        @Override
        public ObservableSource apply(Observable upstream) {
            return upstream.subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread());

        }
    };

    static <T> ObservableTransformer<T, T> applySchedulers() {
        return Stf;
    }

    @SuppressWarnings("unchecked")
    public static <T> ObservableTransformer<T, T> io_main() {
        return (ObservableTransformer<T, T>) applySchedulers();
    }
}

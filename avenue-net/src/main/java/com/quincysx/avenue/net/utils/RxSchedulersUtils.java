package com.quincysx.avenue.net.utils;

import com.quincysx.avenue.net.result.apiverify.TransformerFunc;

import java.lang.reflect.Type;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by quincysx on 2017/9/3.
 */

public final class RxSchedulersUtils {
    public static <T> ObservableTransformer<T, T> thread2Main() {
        return new ObservableTransformer<T, T>() {

            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> ObservableTransformer<String, T> typeTransformer(final Type type) {
        return new ObservableTransformer<String, T>() {
            @Override
            public ObservableSource<T> apply(Observable<String> observable) {
                return observable
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .map(new TransformerFunc<T>(type));
//                        .retryWhen(new ApiRetryFunc(retryCount, retryDelayMillis));
            }
        };
    }
}

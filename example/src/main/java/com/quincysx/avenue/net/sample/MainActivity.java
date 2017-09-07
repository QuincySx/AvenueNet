package com.quincysx.avenue.net.sample;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.quincysx.avenue.net.client.AvenueNetClient;
import com.quincysx.avenue.net.result.ApiCallback;
import com.quincysx.avenue.net.sample.bean.BaseResponse;
import com.quincysx.avenue.net.sample.bean.TestData;

import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        testApi();
//        geterror();

        debugApi();

//        AvenueNetClient.builder("get")
//                .param("name", "test")
//                .build()
//                .get(new ApiCallback<String>() {
//                    @Override
//                    public void onSuccess(String data) {
//                        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
//                    }
//                });

//        AvenueNetClient.builder("get")
//                .param("name", "getname")
//                .build()
//                .get(new ApiCallback<BaseResponse<TestData>>() {
//                    //                .get(new ApiCallback<BaseResponse<TestData>>() {
//                    @Override
//                    public void onSuccess(BaseResponse<TestData> data) {
//                        Toast.makeText(MainActivity.this, "data:" + data, Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onError(ApiException e) {
//                        super.onError(e);
//                    }
//                });

//        AvenueNetClient.builder("get")
//                .param("name", "getname")
//                .build()
//                .get(GetBean.class)
//                .subscribe(new DisposableObserver<GetBean>() {
//                    @Override
//                    public void onNext(@NonNull GetBean getBean) {
//                        Toast.makeText(MainActivity.this, getBean.toString(), Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }

    private void debugApi() {
        AvenueNetClient.builder("index")
                .param("name", "test")
                .build()
                .get(new ApiCallback<String>() {
                    @Override
                    public void onSuccess(String data) {
                        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void testApi() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                get();
            }
        }, 1000);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                post();
            }
        }, 2000);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                postraw();
            }
        }, 3000);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                put();
            }
        }, 4000);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                putraw();
            }
        }, 5000);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                delete();
            }
        }, 6000);
    }

    private void geterror() {
        AvenueNetClient.builder("geterror")
                .param("name", "getname")
                .build()
                .get(new ApiCallback<BaseResponse<TestData>>() {
                    @Override
                    public void onSuccess(BaseResponse<TestData> data) {
                        Toast.makeText(MainActivity.this, "data:" + data, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void get() {
        AvenueNetClient.builder("get")
                .param("name", "getname")
                .build()
                .get(String.class)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void post() {
        AvenueNetClient.builder("post")
                .param("name", "postname")
                .build()
                .post()
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void postraw() {
        AvenueNetClient
                .builder("postraw")
                .param("name", "postrawname")
                .build()
                .post()
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void put() {
        AvenueNetClient.builder("put")
                .param("name", "putname")
                .build()
                .put()
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void putraw() {
        AvenueNetClient.builder("putraw")
                .param("name", "putrawname")
//                .body(RequestBody.create(MediaType.parse("*/*"), "sss"))
                .build()
                .put()
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void delete() {
        AvenueNetClient.builder("delete")
                .param("name", "deletename")
                .build()
                .delete()
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}

package com.quincysx.avenue.net.sample;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.quincysx.avenue.net.client.AvenueNetClient;
import com.quincysx.avenue.net.result.ApiCallback;
import com.quincysx.avenue.net.sample.bean.GetBean;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;

public class MainActivity extends AppCompatActivity {

    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        testApi();

        AvenueNetClient.Builder("get")
                .addParam("name", "getname")
                .build()
                .get(new ApiCallback<GetBean>() {
                    @Override
                    public void onSuccess(GetBean data) {
                        Toast.makeText(MainActivity.this, "data:" + data, Toast.LENGTH_SHORT).show();
                    }
                });

        AvenueNetClient.Builder("get")
                .addParam("name", "getname")
                .build()
                .get(GetBean.class)
                .subscribe(new DisposableObserver<GetBean>() {
                    @Override
                    public void onNext(@NonNull GetBean getBean) {
                        Toast.makeText(MainActivity.this, getBean.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

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

    private void get() {
        AvenueNetClient.Builder("get")
                .addParam("name", "getname")
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
        AvenueNetClient.Builder("post")
                .addParam("name", "postname")
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
                .Builder("postraw")
                .addParam("name", "postrawname")
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
        AvenueNetClient.Builder("put")
                .addParam("name", "putname")
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
        AvenueNetClient.Builder("putraw")
                .addParam("name", "putrawname")
//                .setBody(RequestBody.create(MediaType.parse("*/*"), "sss"))
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
        AvenueNetClient.Builder("delete")
                .addParam("name", "deletename")
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

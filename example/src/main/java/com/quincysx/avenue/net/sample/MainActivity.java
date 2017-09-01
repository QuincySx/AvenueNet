package com.quincysx.avenue.net.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.quincysx.avenue.net.client.AvenueNetClient;

import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AvenueNetClient.Builder()
                .build()
                .get()
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                });
    }
}

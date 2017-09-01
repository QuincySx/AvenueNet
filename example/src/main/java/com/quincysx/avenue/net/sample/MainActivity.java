package com.quincysx.avenue.net.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.quincysx.avenue.net.client.AvenueNetClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AvenueNetClient.Builder()
                .build();
    }
}

package com.canking.paydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.canking.minipay.Config;
import com.canking.minipay.MiniPayUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.go_pay) {
            MiniPayUtils.setupPay(this, new Config.Builder("apafm3kp91df7yo517", R.mipmap.ic_zhifubao, R.mipmap.ic_weixin).build());
        }
    }
}

package com.thoughtworks.iot.buybuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.thoughtworks.iot.buybuddy.service.CreateCartService;

public class ShoppingActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
    }

    void startShopping(View view) {
        CreateCartService createCartService = new CreateCartService(this);
        String[] params = new String[1];
        params[0] = "postCart";
        createCartService.execute(params);
    }
}

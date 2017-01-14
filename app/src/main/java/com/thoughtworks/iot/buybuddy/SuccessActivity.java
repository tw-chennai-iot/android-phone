package com.thoughtworks.iot.buybuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
    }

    public void startAgain(View v){
        Intent intent = new Intent(this, ShoppingActivity.class);
        startActivity(intent);
    }
}

package com.thoughtworks.iot.buybuddy;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.thoughtworks.iot.buybuddy.service.RestService;

public class ShoppingActivity extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
    }

    void startShopping(View view){
        String url ="http://ec2-54-255-184-116.ap-southeast-1.compute.amazonaws.com:3000/cart";
        intent = new Intent(this, NfcReaderActivity.class);
        RestService service = new RestService();
        String[] params = new String[1];
        params[0]="postCart";
        service.execute(params);

    }
}

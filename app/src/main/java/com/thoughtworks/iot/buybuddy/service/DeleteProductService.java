package com.thoughtworks.iot.buybuddy.service;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.iot.buybuddy.LazyAdapter;
import com.thoughtworks.iot.buybuddy.R;
import com.thoughtworks.iot.buybuddy.model.Cart;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DeleteProductService extends AsyncTask<String, Void, String> {
    String url;
    Retrofit retrofit;
    RestAPI restInt;
    Context context;
    LazyAdapter adapter;

    public DeleteProductService(Context context,LazyAdapter adapter) {
        this.context = context;
        this.adapter = adapter;
        url = "http://ec2-54-255-184-116.ap-southeast-1.compute.amazonaws.com:3000";
        retrofit = new Retrofit.Builder()
                .baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        restInt = retrofit.create(RestAPI.class);
    }

    @Override
    protected String doInBackground(String... params) {
        Object result = null;
        String stringResult = null;
        try {
            result = findMethodAndExecute(params);
            ObjectMapper mapper = new ObjectMapper();
            stringResult = mapper.writeValueAsString(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringResult;
    }

    private Object findMethodAndExecute(String[] params) throws IOException {
        Response<Cart> cart = restInt.deleteItemFromCart(params[0], params[1]).execute();
        return cart.body();
    }

    @Override
    protected void onPostExecute(String result) {
        try {
            Cart cart = new ObjectMapper().readValue(result, Cart.class);
            adapter.clear();
            adapter.addAll(cart.products);
            TextView totalPrice = (TextView) ((Activity)context).findViewById(R.id.totalPrice);
            totalPrice.setText(""+cart.value);
            TextView status = (TextView) ((Activity)context).findViewById(R.id.status);
            status.setText(cart.status);
            if(cart.products.size()== 0){
                totalPrice = (TextView) ((Activity)context).findViewById(R.id.totalPrice);
                totalPrice.setVisibility(View.INVISIBLE);
                status = (TextView) ((Activity)context).findViewById(R.id.status);
                status.setVisibility(View.INVISIBLE);
                Button payButton = (Button) ((Activity)context).findViewById(R.id.buttonPay);
                payButton.setVisibility(View.INVISIBLE);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

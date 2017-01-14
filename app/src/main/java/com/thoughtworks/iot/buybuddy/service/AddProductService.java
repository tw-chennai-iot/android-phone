package com.thoughtworks.iot.buybuddy.service;

import android.content.Context;
import android.os.AsyncTask;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.iot.buybuddy.LazyAdapter;
import com.thoughtworks.iot.buybuddy.model.Cart;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddProductService extends AsyncTask<String, Void, String> {
    String url;
    Retrofit retrofit;
    RestAPI restInt;
    Context context;
    LazyAdapter adapter;

    public AddProductService(Context context, LazyAdapter adapter) {
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
        Map<String, String> tag = new HashMap<>();
        tag.put("tagId", params[1]);
        Response<Cart> cart = restInt.addItemToCart(params[0], tag).execute();
        return cart.body();
    }

    @Override
    protected void onPostExecute(String result) {
        try {
            Cart cart = new ObjectMapper().readValue(result, Cart.class);
            adapter.insert(cart.products.get(cart.products.size() - 1), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

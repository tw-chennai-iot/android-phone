package com.thoughtworks.iot.buybuddy.service;

import com.thoughtworks.iot.buybuddy.model.Cart;
import com.thoughtworks.iot.buybuddy.model.ResponseFrom;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RestAPI{
    @GET("/devices/{cart-id}/{nfc-id}")
    Call<ResponseFrom> sendNfcId(@Path("cart-id") String cartId, @Path("nfc-id") String nfcId);

    @POST("/user/{email-id}/{password}")
    Call<String> loginUser(@Path("email-id") String emailId, @Path("password") String password);

    @POST("/cart")
    Call<Cart> createCart();
}

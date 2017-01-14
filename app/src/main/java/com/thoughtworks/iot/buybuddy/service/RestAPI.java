package com.thoughtworks.iot.buybuddy.service;

import com.thoughtworks.iot.buybuddy.model.Cart;
import com.thoughtworks.iot.buybuddy.model.Product;
import com.thoughtworks.iot.buybuddy.model.ResponseFrom;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
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

    @POST("/{cart-id}")
    Call<Cart> addItemToCart(@Path("cart-id")String cartId, @Body() Map<String,String> tagDetails);

    @DELETE("/{cart-id}")
    Call<Cart> deleteItemFromCart(@Path("cart-id")String cartId, @Body() Map<String,String> tagDetails);

}

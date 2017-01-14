package com.thoughtworks.iot.buybuddy.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public String _id;
    public double totalPrice;
    public List<Product> products = new ArrayList<>();
    public String status;
}

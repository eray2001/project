package com.d288.backendprogramming.services;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}

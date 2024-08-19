package com.d288.backendprogramming.services;

import com.d288.backendprogramming.entities.Cart;
import com.d288.backendprogramming.entities.CartItem;
import com.d288.backendprogramming.entities.Customer;
import lombok.Data;
import org.hibernate.query.Order;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;

}

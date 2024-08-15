package com.d288.backendprogramming.dao;

import com.d288.backendprogramming.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepo extends JpaRepository<CartItem, Long> {
}

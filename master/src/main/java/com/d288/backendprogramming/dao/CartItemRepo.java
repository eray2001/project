package com.d288.backendprogramming.dao;

import com.d288.backendprogramming.entities.CartItem;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CartItemRepo extends JpaRepository<CartItem, Long> {
}

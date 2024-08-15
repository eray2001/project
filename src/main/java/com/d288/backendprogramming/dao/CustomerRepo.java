package com.d288.backendprogramming.dao;

import com.d288.backendprogramming.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}

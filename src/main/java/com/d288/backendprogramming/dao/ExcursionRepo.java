package com.d288.backendprogramming.dao;

import com.d288.backendprogramming.entities.Excursion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExcursionRepo extends JpaRepository<Excursion, Long> {
}

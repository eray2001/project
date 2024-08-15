package com.d288.backendprogramming.dao;

import com.d288.backendprogramming.entities.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepo extends JpaRepository<Division, Long> {
}

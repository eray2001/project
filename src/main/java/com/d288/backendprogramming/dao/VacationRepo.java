package com.d288.backendprogramming.dao;

import com.d288.backendprogramming.entities.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationRepo extends JpaRepository<Vacation, Long> {
}

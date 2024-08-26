package com.d288.backendprogramming.dao;

import com.d288.backendprogramming.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CountryRepo extends JpaRepository<Country, Long> {
}

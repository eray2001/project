package com.d288.backendprogramming.dao;

import com.d288.backendprogramming.entities.STATUSTYPE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusTypeRepo extends JpaRepository<STATUSTYPE, Enum> {
}

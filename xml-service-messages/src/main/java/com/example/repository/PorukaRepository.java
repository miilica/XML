package com.example.repository;

import com.example.model.Poruka;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PorukaRepository extends JpaRepository<Long, Poruka> {
}

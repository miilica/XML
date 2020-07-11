package com.example.demo.repository;

import com.example.demo.model.TipMjenjaca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipMjenjacaRepository extends JpaRepository<TipMjenjaca, Long> {

    TipMjenjaca findById(String id);
}

package com.example.demo.repository;

import com.example.demo.model.KlasaAutomobila;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KlasaAutoRepository extends JpaRepository<KlasaAutomobila, Long> {

    KlasaAutomobila findById(String id);
}

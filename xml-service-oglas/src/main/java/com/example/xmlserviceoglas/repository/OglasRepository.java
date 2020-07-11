package com.example.xmlserviceoglas.repository;

import com.example.xmlserviceoglas.model.Oglas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OglasRepository extends JpaRepository<Oglas, Long> {
}

package com.repository;

import com.model.Oglas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OglasRepository extends JpaRepository<Oglas, Long> {

    Oglas findById (String id);
}
package com.repository;

import com.model.Slika;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlikeRepository extends JpaRepository<Slika, Long> {
}

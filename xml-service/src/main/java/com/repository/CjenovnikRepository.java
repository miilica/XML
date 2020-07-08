package com.repository;

import com.model.Cjenovnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CjenovnikRepository extends JpaRepository<Cjenovnik, Long> {
    List<Cjenovnik> findAllByUserUsername(String username);
}

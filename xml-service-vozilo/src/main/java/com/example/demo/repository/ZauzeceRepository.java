package com.example.demo.repository;

import com.example.demo.model.Zauzece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ZauzeceRepository extends JpaRepository<Zauzece,Long> {
}

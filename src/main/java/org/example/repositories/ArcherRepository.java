package org.example.repositories;

import org.example.models.Archer;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArcherRepository extends JpaRepository<Archer, Long> {

    // Метод для поиска лучника по cloudId
    Optional<Archer> findByCloudId(String cloudId);

    // Метод для получения случайного лучника
    Optional<Archer> findRandomBy();

    Archer findTopByOrderByIdDesc();

}

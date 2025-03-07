package org.example.repositories;

import org.example.models.Archer;
import org.example.models.Mage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MageRepository extends JpaRepository<Mage, Long> {

    // Метод для поиска мага по cloudId
    Optional<Mage> findByCloudId(String cloudId);

    // Метод для получения случайного мага
    Optional<Mage> findRandomBy();

    Mage findTopByOrderByIdDesc();
}

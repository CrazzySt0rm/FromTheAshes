package org.example.repositories;

import org.example.models.Warrior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarriorRepository extends JpaRepository<Warrior, String> {
}

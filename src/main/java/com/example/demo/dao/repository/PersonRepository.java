package com.example.demo.dao.repository;

import com.example.demo.dao.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<PersonEntity, String> {
    List<PersonEntity> findPersonEntitiesByFirstName(String firstName);

    PersonEntity findPersonEntityById(UUID id);
}
package com.example.personcontactservice.repository;

import com.example.personcontactservice.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByName(String name);

    void deleteByName(String name);
}

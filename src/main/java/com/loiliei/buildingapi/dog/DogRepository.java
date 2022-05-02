package com.loiliei.buildingapi.dog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {

    Optional<Dog> findDogByName(String name);
    Optional<Dog> findDogByAgeGreaterThanAndName(int age, String name);
}

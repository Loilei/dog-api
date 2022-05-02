package com.loiliei.buildingapi.dog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {
    private final DogRepository repository;

    @Autowired
    public DogService(DogRepository repository) {
        this.repository = repository;
    }

    public List<Dog> getAll() {
        return repository.findAll();
    }

    public Dog add(Dog dog) {
        return repository.save(dog);
    }

    public Dog update(Dog dogInfoToUpdate, Long dogId) {
        Dog dog = repository.findById(dogId).orElseThrow(() -> new IllegalStateException("Dog with Id " + dogId + " not found"));
        dog.setName(dogInfoToUpdate.getName());
        repository.save(dog);
        return dog;
    }

    public void deleteByID(Long dogId) {
        try {
            repository.deleteById(dogId);
        } catch (Exception e) {
            throw new IllegalArgumentException("Dog with Id " + dogId + " not found");
        }
    }
}

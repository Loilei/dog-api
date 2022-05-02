package com.loiliei.buildingapi.dog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/dog")
public class DogController {
    private final DogService service;

    @Autowired
    public DogController(DogService service) {
        this.service = service;
    }

    @GetMapping
    public List<Dog> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Dog add(@RequestBody Dog dog) {
        return service.add(dog);
    }

    @PutMapping(path = "/{dogId}")
    public Dog update(@RequestBody Dog dogInfoToUpdate, @PathVariable("dogId") Long dogId) {
        return service.update(dogInfoToUpdate, dogId);
    }

    @DeleteMapping(path = "/{dogId}")
    public void deleteById(@PathVariable("dogId") Long dogId) {
        service.deleteByID(dogId);
    }

}

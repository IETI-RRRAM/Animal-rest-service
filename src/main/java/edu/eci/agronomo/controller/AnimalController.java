package edu.eci.agronomo.controller;

import edu.eci.agronomo.model.animal.Animal;
import edu.eci.agronomo.model.animal.AnimalDto;
import edu.eci.agronomo.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    // Create a new animal
    @PostMapping
    public ResponseEntity<Animal> createAnimal(@RequestBody AnimalDto animal) {
        Animal createdAnimal = animalService.save(animal);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnimal);
    }
}

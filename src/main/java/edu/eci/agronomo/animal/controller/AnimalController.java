package edu.eci.agronomo.animal.controller;

import edu.eci.agronomo.animal.exceptions.AnimalNotFoundException;
import edu.eci.agronomo.animal.model.animal.Animal;
import edu.eci.agronomo.animal.model.animal.AnimalDto;
import edu.eci.agronomo.animal.service.AnimalService;
import edu.eci.agronomo.animal.service.AnimalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    @Autowired
    private AnimalServiceImpl animalService;

    // Get all animals
    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalService.findAll();
    }

    // Get animal by ID
    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable String id) {
        Optional<Animal> animal = animalService.findById(id);
        if (animal.isPresent()) {
            return ResponseEntity.ok(animal.get());
        } else {
            throw new AnimalNotFoundException(id);
        }
    }

    // Create a new animal
    @PostMapping
    public ResponseEntity<Animal> createAnimal(@RequestBody AnimalDto animal) {
        Animal createdAnimal = animalService.save(animal);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnimal);
    }

    // Delete an animal
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable String id) {
        Optional<Animal> animal = animalService.findById(id);
        if (animal.isPresent()) {
            animalService.delete(animal.get().getId());
            return ResponseEntity.ok().build();
        } else {
            throw new AnimalNotFoundException(id);
        }
    }

    //update a animal
    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable String id, @RequestBody AnimalDto updatedAnimal) {
        Optional<Animal> animal = animalService.findById(id);
        if (animal.isPresent()) {
            Animal savedAnimal = animalService.update(id, updatedAnimal);
            return ResponseEntity.ok(savedAnimal);
        } else {
            throw new AnimalNotFoundException(id);
        }
    }
}

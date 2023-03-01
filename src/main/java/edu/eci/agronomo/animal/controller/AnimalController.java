package edu.eci.agronomo.animal.controller;

import edu.eci.agronomo.animal.model.Animal;
import edu.eci.agronomo.animal.service.AnimalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animals")
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
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new animal
    @PostMapping
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal) {
        Animal createdAnimal = animalService.save(animal);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnimal);
    }

    // Update an existing animal
    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable String id, @RequestBody Animal updatedAnimal) {
        Optional<Animal> animal = animalService.findById(id);
        if (animal.isPresent()) {
            updatedAnimal.setId(id);
            Animal savedAnimal = animalService.save(updatedAnimal);
            return ResponseEntity.ok(savedAnimal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an animal
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable String id) {
        Optional<Animal> animal = animalService.findById(id);
        if (animal.isPresent()) {
            animalService.delete(animal.get().getId());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

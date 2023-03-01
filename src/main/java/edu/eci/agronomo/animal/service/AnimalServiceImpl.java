package edu.eci.agronomo.animal.service;

import edu.eci.agronomo.animal.model.animal.Animal;
import edu.eci.agronomo.animal.model.animal.AnimalDto;
import edu.eci.agronomo.animal.repository.AnimalRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    AnimalRepositoryImpl animalRepository;

    @Override
    public ArrayList<Animal> findAll() {
        return animalRepository.findAll();
    }

    @Override
    public Optional<Animal> findById(String id) {
        return animalRepository.findById(id);
    }

    @Override
    public Animal save(AnimalDto animal) {
        return animalRepository.save(animal);
    }

    @Override
    public void delete(String id) {
        animalRepository.delete(id);
    }

    @Override
    public Animal update(String id, AnimalDto animal) {
        return animalRepository.update(id, animal);
    }

}

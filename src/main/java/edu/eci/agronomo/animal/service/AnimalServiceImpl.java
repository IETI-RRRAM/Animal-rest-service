package edu.eci.agronomo.animal.service;

import edu.eci.agronomo.animal.model.animal.Animal;
import edu.eci.agronomo.animal.model.animal.AnimalDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {

    private HashMap<String, Animal> animals = new HashMap<>();

    @Override
    public ArrayList<Animal> findAll() {
        ArrayList<Animal> getAnimals = new ArrayList<>();
        for (Animal a : animals.values()) {
            getAnimals.add(a);
        }
        return getAnimals;
    }

    @Override
    public Optional<Animal> findById(String id) {
        return Optional.ofNullable(animals.get(id));
    }

    @Override
    public Animal save(AnimalDto animal) {
        String key = String.valueOf(animals.size()+1);
        animals.put(key, new Animal(key, animal));
        return animals.get(key);
    }

    @Override
    public Animal update(String id, AnimalDto animal) {
        animals.put(id, new Animal(id, animal));
        return animals.get(id);
    }

}

package edu.eci.agronomo.animal.service;

import edu.eci.agronomo.animal.model.Animal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {

    private HashMap<String, Animal> animals = new HashMap<>();

    @Override
    public ArrayList<Animal> findAll() {
        ArrayList<Animal> get_animals = new ArrayList<>();
        for (Animal a : animals.values()) {
            get_animals.add(a);
        }
        return get_animals;
    }

    @Override
    public Optional<Animal> findById(String id) {
        return Optional.ofNullable(animals.get(id));
    }
}
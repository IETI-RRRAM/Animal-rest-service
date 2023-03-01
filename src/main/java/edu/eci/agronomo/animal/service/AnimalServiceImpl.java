package edu.eci.agronomo.animal.service;

import edu.eci.agronomo.animal.model.Animal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {

    private HashMap<Long, Animal> animals = new HashMap<>();

    public AnimalServiceImpl() {
        Animal animal1 = new Animal(1, 122, "caramelo", "cow", "hembra");
        animals.put(animal1.getId(), animal1);
    }

    @Override
    public ArrayList<Animal> findAll() {
        ArrayList<Animal> get_animals = new ArrayList<>();
        for (Animal a : animals.values()) {
            get_animals.add(a);
        }
        return get_animals;
    }

    @Override
    public Optional<Animal> findById(Long id) {
        return Optional.ofNullable(animals.get(id));
    }
}

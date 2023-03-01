package edu.eci.agronomo.service;

import edu.eci.agronomo.model.animal.Animal;
import edu.eci.agronomo.model.animal.AnimalDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AnimalServiceImpl implements AnimalService{

    HashMap<String, Animal> animals = new HashMap<>();

    @Override
    public Animal save(AnimalDto animal) {
        String key = String.valueOf(animals.size()+1);
        animals.put(key, new Animal(key, animal));
        return animals.get(key);
    }
}

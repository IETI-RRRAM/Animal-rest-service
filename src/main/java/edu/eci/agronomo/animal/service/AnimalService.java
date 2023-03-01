package edu.eci.agronomo.animal.service;

import edu.eci.agronomo.animal.model.animal.Animal;
import edu.eci.agronomo.animal.model.animal.AnimalDto;

import java.util.ArrayList;
import java.util.Optional;

public interface AnimalService {

    public ArrayList<Animal> findAll();

    public Optional<Animal> findById(String id);

    public Animal save(AnimalDto animal);

}

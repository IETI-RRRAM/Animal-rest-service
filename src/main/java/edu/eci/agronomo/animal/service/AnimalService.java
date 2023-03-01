package edu.eci.agronomo.animal.service;

import edu.eci.agronomo.animal.model.Animal;

import java.util.ArrayList;
import java.util.Optional;

public interface AnimalService {

    public ArrayList<Animal> findAll();

    public Optional<Animal> findById(Long id);
}

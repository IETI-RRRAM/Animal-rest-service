package edu.eci.agronomo.animal.repository;

import edu.eci.agronomo.animal.model.animal.Animal;
import edu.eci.agronomo.animal.model.animal.AnimalDto;

import java.util.ArrayList;
import java.util.Optional;

public interface AnimalRepository {

    public ArrayList<Animal> findAll();

    public Optional<Animal> findById(String id);

    public Animal save(AnimalDto animal);

    public void delete(String id);

    public Animal update(String id, AnimalDto animal);

}

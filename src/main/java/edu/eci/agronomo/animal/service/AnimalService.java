package edu.eci.agronomo.animal.service;

import edu.eci.agronomo.animal.model.animal.Animal;
import edu.eci.agronomo.animal.model.animal.AnimalDto;

public interface AnimalService {
    public Animal save(AnimalDto animal);
}

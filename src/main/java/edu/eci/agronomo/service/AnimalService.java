package edu.eci.agronomo.service;

import edu.eci.agronomo.model.animal.Animal;
import edu.eci.agronomo.model.animal.AnimalDto;

public interface AnimalService {
    public Animal save(AnimalDto animal);
}

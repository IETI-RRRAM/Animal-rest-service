package edu.eci.agronomo.animal.repository;

import edu.eci.agronomo.animal.model.animal.Animal;
import edu.eci.agronomo.animal.model.animal.AnimalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class AnimalRepositoryImpl implements AnimalRepository{

    @Autowired
    private final MongoTemplate mongoTemplate;

    public AnimalRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public ArrayList<Animal> findAll() {
        return null;
    }

    @Override
    public Optional<Animal> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Animal save(AnimalDto animal) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Animal update(String id, AnimalDto animal) {
        return null;
    }
}

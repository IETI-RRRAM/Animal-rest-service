package edu.eci.agronomo.animal.repository;

import edu.eci.agronomo.animal.model.animal.Animal;
import edu.eci.agronomo.animal.model.animal.AnimalDto;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
        return (ArrayList<Animal>) mongoTemplate.findAll(Animal.class);
    }

    @Override
    public Optional<Animal> findById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return Optional.ofNullable(mongoTemplate.findOne(query, Animal.class));
    }

    @Override
    public Animal save(AnimalDto animal) {
        return mongoTemplate.save(new Animal(String.valueOf(ObjectId.get()), animal));
    }

    @Override
    public void delete(String id) {
        mongoTemplate.remove(new Query(Criteria.where("id").is(id)), Animal.class);
    }

    @Override
    public Animal update(String id, AnimalDto animal) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update()
                .set("idRanch", animal.getIdRanch())
                .set("name", animal.getName())
                .set("type", animal.getType())
                .set("gender", animal.getGender())
                .set("breed", animal.getBreed())
                .set("age", animal.getAge())
                .set("weight", animal.getWeight())
                .set("stage", animal.getStage());
        mongoTemplate.updateFirst(query, update, Animal.class);
        return findById(id).orElse(null);
    }
}

package edu.eci.agronomo.animal.model.animal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "animal_collection")
public class Animal implements Serializable {

    @Id
    private String id;
    private String idRanch;
    private String name;
    private String type;
    private String gender;
    private String stage;
    private String weight;
    private String breed;
    private String age;

    public Animal(String id, String idRanch, String name, String type, String gender, String stage, String weight, String breed, String age) {
        this.id = id;
        this.idRanch = idRanch;
        this.name = name;
        this.type = type;
        this.gender = gender;
        this.stage = stage;
        this.weight = weight;
        this.breed = breed;
        this.age = age;
    }

    public Animal(String idRanch, String name, String type, String gender, String stage, String weight, String breed, String age) {
        this.idRanch = idRanch;
        this.name = name;
        this.type = type;
        this.gender = gender;
        this.stage = stage;
        this.weight = weight;
        this.breed = breed;
        this.age = age;
    }

    public Animal(String id, AnimalDto animalDto) {
        this.id = id;
        this.idRanch = animalDto.getIdRanch();
        this.name = animalDto.getName();
        this.type = animalDto.getType();
        this.gender = animalDto.getGender();
        this.stage = animalDto.getStage();
        this.weight = animalDto.getWeight();
        this.breed = animalDto.getBreed();
        this.age = animalDto.getAge();
    }

    public Animal() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdRanch() {
        return idRanch;
    }

    public void setIdRanch(String idRanch) {
        this.idRanch = idRanch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
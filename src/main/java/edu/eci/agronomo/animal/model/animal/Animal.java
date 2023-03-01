package edu.eci.agronomo.animal.model.animal;

public class Animal {

    private String id;
    private String idRanch;
    private String name;
    private String type;
    private String gender;

    public Animal(String id, String idRanch, String name, String type, String gender) {
        this.id = id;
        this.idRanch = idRanch;
        this.name = name;
        this.type = type;
        this.gender = gender;
    }

    public Animal(String id, AnimalDto animalDto) {
        this.id = id;
        this.idRanch = animalDto.getIdRanch();
        this.name = animalDto.getName();
        this.type = animalDto.getType();
        this.gender = animalDto.getGender();
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
}
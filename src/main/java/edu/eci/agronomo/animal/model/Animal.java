package edu.eci.agronomo.animal.model;

public class Animal {

    private String id;
    private String idFarm;
    private String name;
    private String type;
    private String gender;

    public Animal(String id, String idFarm, String name, String type, String gender) {
        this.id = id;
        this.idFarm = idFarm;
        this.name = name;
        this.type = type;
        this.gender = gender;
    }

    public Animal() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdFarm() {
        return idFarm;
    }

    public void setIdFarm(String idFarm) {
        this.idFarm = idFarm;
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

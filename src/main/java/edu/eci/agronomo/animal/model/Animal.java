package edu.eci.agronomo.animal.model;

public class Animal {

    private long id;
    private long idFarm;
    private String name;
    private String type;
    private String gender;

    public Animal(long id, long id_farm, String name, String type, String gender) {
        this.id = id;
        this.idFarm = id_farm;
        this.name = name;
        this.type = type;
        this.gender = gender;
    }

    public Animal() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_farm() {
        return idFarm;
    }

    public void setId_farm(long id_farm) {
        this.idFarm = id_farm;
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

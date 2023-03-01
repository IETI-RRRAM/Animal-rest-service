package edu.eci.agronomo.model.animal;

public class AnimalDto {
    private String idFarm;
    private String name;
    private String type;
    private String gender;

    public AnimalDto(String idFarm, String name, String type, String gender) {
        this.idFarm = idFarm;
        this.name = name;
        this.type = type;
        this.gender = gender;
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

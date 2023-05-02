package org.example.spring.models;

public class City {

    private int id;
    private String name;
    private Long population;
    private Double latitude;
    private Double longitude;
    private int stateId;

    // Constructors
    public City() {
    }

    public City(int id, String name, Long population, Double latitude, Double longitude, int stateId) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.latitude = latitude;
        this.longitude = longitude;
        this.stateId = stateId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }
}
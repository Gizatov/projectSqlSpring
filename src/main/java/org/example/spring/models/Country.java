package org.example.spring.models;

public class Country {

    private int id;
    private String name;
    private String capital;
    private Long population;
    private Long landArea;

    // Constructors
    public Country() {
    }

    public Country(int id, String name, String capital, Long population, Long landArea) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.landArea = landArea;
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

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getLandArea() {
        return landArea;
    }

    public void setLandArea(Long landArea) {
        this.landArea = landArea;
    }
}

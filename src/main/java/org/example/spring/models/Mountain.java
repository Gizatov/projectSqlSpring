package org.example.spring.models;

public class Mountain {

    private int id;
    private String name;
    private Double height;
    private Long countryId;

    // Constructors
    public Mountain() {
    }

    public Mountain(int id, String name, Double height, Long countryId) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.countryId = countryId;
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

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}
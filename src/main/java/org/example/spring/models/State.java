package org.example.spring.models;

public class State {

    private int id;
    private String name;
    private String abbreviation;
    private Long countryId;

    // Constructors
    public State() {
    }

    public State(int id, String name, String abbreviation, Long countryId) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
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

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}

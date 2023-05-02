package org.example.spring.models;

public class River {

    private Long id;
    private String name;
    private Double length;
    private Long countryId;

    // Constructors
    public River() {
    }

    public River(Long id, String name, Double length, Long countryId) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.countryId = countryId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}
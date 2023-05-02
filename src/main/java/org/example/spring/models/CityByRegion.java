package org.example.spring.models;

import java.math.BigDecimal;

public class CityByRegion {
    private int cityId;
    private String cityName;
    private long population;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String stateName;
    private String stateAbbreviation;
    private String countryName;
    private String countryCapital;
    private long countryPopulation;
    private long countryLandArea;

    public CityByRegion(){}
    public CityByRegion(int cityId, String cityName, long population, BigDecimal latitude, BigDecimal longitude, String stateName, String stateAbbreviation, String countryName, String countryCapital, long countryPopulation, long countryLandArea) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.population = population;
        this.latitude = latitude;
        this.longitude = longitude;
        this.stateName = stateName;
        this.stateAbbreviation = stateAbbreviation;
        this.countryName = countryName;
        this.countryCapital = countryCapital;
        this.countryPopulation = countryPopulation;
        this.countryLandArea = countryLandArea;
    }

    public CityByRegion(String cityName, long population, BigDecimal latitude, BigDecimal longitude, String stateName, String stateAbbreviation, String countryName, String countryCapital, long countryPopulation, long countryLandArea) {
        this.cityName = cityName;
        this.population = population;
        this.latitude = latitude;
        this.longitude = longitude;
        this.stateName = stateName;
        this.stateAbbreviation = stateAbbreviation;
        this.countryName = countryName;
        this.countryCapital = countryCapital;
        this.countryPopulation = countryPopulation;
        this.countryLandArea = countryLandArea;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public void setCountryCapital(String countryCapital) {
        this.countryCapital = countryCapital;
    }

    public long getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(long countryPopulation) {
        this.countryPopulation = countryPopulation;
    }

    public long getCountryLandArea() {
        return countryLandArea;
    }

    public void setCountryLandArea(long countryLandArea) {
        this.countryLandArea = countryLandArea;
    }
}
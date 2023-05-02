package org.example.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.example.spring.models.City;
import org.example.spring.models.CityByRegion;
import org.example.spring.models.CityInfo;

import java.util.List;

@Component
public class CityDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CityDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<City> getAllCities() {
        return jdbcTemplate.query("SELECT * FROM cities", new BeanPropertyRowMapper<>(City.class));
    }

    public List<City> findByNameContainingIgnoreCase(String name) {
        String query = "SELECT * FROM cities WHERE LOWER(name) LIKE ?";
        String nameLike = "%" + name.toLowerCase() + "%";
        return jdbcTemplate.query(query, new Object[]{nameLike}, new BeanPropertyRowMapper<>(City.class));
    }


    public List<City> getCitiesByStateId(int stateId) {
        return jdbcTemplate.query("SELECT * FROM cities WHERE city_id = ?", new Object[]{stateId}, new BeanPropertyRowMapper<>(City.class));
    }
    public void addCity(City city) {
        jdbcTemplate.update("INSERT INTO cities (name, population, latitude, longitude, state_id) VALUES (?, ?, ?, ?, ?)",
                city.getName(), city.getPopulation(), city.getLatitude(), city.getLongitude(),city.getStateId());
    }
    public City getCityById(int city_id) {
        return jdbcTemplate.queryForObject("SELECT * FROM cities WHERE city_id = ?", new Object[]{city_id}, new BeanPropertyRowMapper<>(City.class));
    }

    public List<CityInfo> getAllCitiesInfo() {
        return jdbcTemplate.query("SELECT * FROM city_info", new BeanPropertyRowMapper<>(CityInfo.class));
    }

    public void deleteCity(int id) {
        jdbcTemplate.update("DELETE FROM cities WHERE city_id = ?", id);
    }

    public int countOfPopulation() {
        return  jdbcTemplate.queryForObject("SELECT SUM(population) FROM cities",Integer.class);
    }
    public List<CityByRegion> getCitiesByRegion(String regionName) {
        return jdbcTemplate.query("SELECT * FROM get_cities_by_region(?)", new Object[]{regionName},
                new BeanPropertyRowMapper<>(CityByRegion.class));
    }
}
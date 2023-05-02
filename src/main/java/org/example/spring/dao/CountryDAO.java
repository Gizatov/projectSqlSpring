package org.example.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.example.spring.models.Country;

import java.util.List;

@Component
public class CountryDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CountryDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Country> findAll() {
        return jdbcTemplate.query("SELECT * FROM countries", new BeanPropertyRowMapper<>(Country.class));
    }

    public Country findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM countries WHERE country_id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Country.class));
    }

    public List<Country> findByContinent(String continent) {
        return jdbcTemplate.query("SELECT * FROM countries WHERE continent = ?", new Object[]{continent}, new BeanPropertyRowMapper<>(Country.class));
    }

    public void save(Country country) {
        jdbcTemplate.update("INSERT INTO countries (name, capital, population, land_area) VALUES (?, ?, ?, ?)",
                country.getName(), country.getCapital(), country.getPopulation(), country.getLandArea());
    }

    public void update(Country country) {
        jdbcTemplate.update("UPDATE countries SET name = ?, capital = ?, population = ?, land_area = ? WHERE id = ?",
                country.getName(), country.getCapital(), country.getPopulation(), country.getLandArea(), country.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM countries WHERE id = ?", id);
    }
}

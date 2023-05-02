package org.example.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.example.spring.models.River;

import java.util.List;

@Component
public class RiverDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RiverDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<River> getAllRivers() {
        return jdbcTemplate.query("SELECT * FROM rivers",  new BeanPropertyRowMapper<>(River.class));
    }

    public List<River> getRiversByCountryId(int countryId) {
        return jdbcTemplate.query("SELECT * FROM rivers WHERE country_id = ?",
                new Object[]{countryId}, new BeanPropertyRowMapper<>(River.class));
    }


}


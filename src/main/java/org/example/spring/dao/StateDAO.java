package org.example.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.example.spring.models.State;

import java.util.List;

@Component
public class StateDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StateDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<State> findAll() {
        return jdbcTemplate.query("SELECT * FROM states",  new BeanPropertyRowMapper<>(State.class));
    }

    public State getStateById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM states WHERE state_id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(State.class));
    }

}

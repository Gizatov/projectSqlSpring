package org.example.spring.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(User user) {
        jdbcTemplate.update("INSERT INTO users (email, password) VALUES (?, ?)",
                user.getEmail(), user.getPassword());
    }

    public User findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }

    public User findByEmail(String email) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE email = ?",new Object[]{email},new BeanPropertyRowMapper<>(User.class));
    }
}

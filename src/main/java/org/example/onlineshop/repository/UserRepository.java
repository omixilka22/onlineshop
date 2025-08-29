package org.example.onlineshop.repository;

import org.example.onlineshop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(User user) {
        jdbc.update("INSERT INTO users (username, email, password, role) VALUES (?, ?, ?, ?)"
        , user.getName(), user.getEmail(), user.getPassword(), user.getRole());
    }

    public User findById(int id) {
        return jdbc.queryForObject("SELECT * FROM users WHERE id = ?",
                new BeanPropertyRowMapper<>(User.class) ,id);
    }

    public User findByUsername(String username) {
        return jdbc.queryForObject("SELECT * FROM users WHERE username = ?",
                new BeanPropertyRowMapper<>(User.class) ,username);
    }

    public User findByEmail(String email) {
        return jdbc.queryForObject("SELECT * FROM users WHERE email = ?",
                new BeanPropertyRowMapper<>(User.class) ,email);
    }

    public List<User> findAll() {
        return jdbc.query("SELECT * FROM users ORDER BY username ASC",
                new BeanPropertyRowMapper<>(User.class));
    }

    public void deleteById(int id) {
        jdbc.update("DELETE FROM users WHERE id = ?", id);
    }

}

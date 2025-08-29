package org.example.onlineshop.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.example.onlineshop.model.Order;

import java.util.List;

@Repository
public class OrderRepository {

    private JdbcTemplate jdbc;

    public OrderRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Order order) {
        jdbc.update("INSERT INTO orders (user_id, product_id, quantity) VALUES (?, ?, ?)"
        , order.getUserId(), order.getProductId(), order.getQuantity());
    }

    public List<Order> findByUserId(int userId) {
        return jdbc.query("SELECT * from orders WHERE user_id = ?",
                new BeanPropertyRowMapper<>(Order.class)
                ,userId);
    }

    public List<Order> findAll() {
        return jdbc.query("SELECT * from orders", new BeanPropertyRowMapper<>(Order.class));
    }

    public void deleteById(int orderId) {
        jdbc.update("DELETE FROM orders WHERE id = ?", orderId);
    }
}

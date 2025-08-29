package org.example.onlineshop.repository;

import org.example.onlineshop.model.Order;
import org.example.onlineshop.model.Product;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    private JdbcTemplate jdbc;

    public ProductRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Product product) {
        jdbc.update("INSERT INTO products (name , description , price) VALUES (?, ?, ?)"
                , product.getName(), product.getDescription(), product.getPrice());
    }

    public Product findById(int id) {
        return jdbc.queryForObject(
                "SELECT * FROM products WHERE id = ?",
                new BeanPropertyRowMapper<>(Product.class),
                id
        );
    }

    public List<Product> findAll() {
        return jdbc.query("SELECT * from products", new BeanPropertyRowMapper<>(Product.class));
    }

    public void deleteById(int productId) {
        jdbc.update("DELETE FROM products WHERE id = ?", productId);
    }
}

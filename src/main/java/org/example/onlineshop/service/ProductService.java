package org.example.onlineshop.service;

import org.example.onlineshop.model.Product;
import org.example.onlineshop.model.Role;
import org.example.onlineshop.model.User;
import org.example.onlineshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(int id) {
        return productRepository.findById(id);
    }

    public void save(Product product , User currentUser) {
        if (!currentUser.getRole().equals(Role.ADMIN)) {
            throw new RuntimeException("Тільки адміністратор може додавати продукти");
        }

        productRepository.save(product);
    }

    public void deleteById(int id, User currentUser) {
        if (!currentUser.getRole().equals(Role.ADMIN)) {
            throw new RuntimeException("Тільки адміністратор може видаляти продукти");
        }
        productRepository.deleteById(id);
    }

}

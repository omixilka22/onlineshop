package org.example.onlineshop.service;

import org.example.onlineshop.model.Order;
import org.example.onlineshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void save(Order order) {
        orderRepository.save(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Order> findById(int orderId) {
        return orderRepository.findByUserId(orderId);
    }


    public void deleteById(int orderId) {
        orderRepository.deleteById(orderId);
    }
}

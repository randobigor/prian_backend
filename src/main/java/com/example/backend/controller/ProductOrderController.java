package com.example.backend.controller;


import com.example.backend.model.ProductOrder;
import com.example.backend.repository.ProductOrderRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import jakarta.annotation.Resource;

@CrossOrigin(originPatterns = "*", maxAge = 3600)
@RestController
@RequestMapping("/product-order")
public class ProductOrderController {

  @Resource
  private ProductOrderRepository productOrderRepository;

  @GetMapping
  public List<ProductOrder> getAllOrders() {
    return productOrderRepository.findAll();
  }

  @PostMapping
  public void placeOrder(@RequestBody ProductOrder order) {
    productOrderRepository.save(order);
  }

  @DeleteMapping("/{id}")
  public void deleteOrder(@PathVariable long id) {
    productOrderRepository.deleteById(id);
  }
}

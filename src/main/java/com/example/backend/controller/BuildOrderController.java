package com.example.backend.controller;

import com.example.backend.model.BuildOrder;
import com.example.backend.repository.BuildOrderRepository;

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
@RequestMapping("/build-order")
public class BuildOrderController {

  @Resource
  private BuildOrderRepository buildOrderRepository;

  @GetMapping
  public List<BuildOrder> findAll() {
    return buildOrderRepository.findAll();
  }

  @PostMapping
  public void placeOrder(@RequestBody BuildOrder order) {
    buildOrderRepository.save(order);
  }

  @DeleteMapping("/{id}")
  public void deleteOrder(@PathVariable long id) {
    buildOrderRepository.deleteById(id);
  }
}

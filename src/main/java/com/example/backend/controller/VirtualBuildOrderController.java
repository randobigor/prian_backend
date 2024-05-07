package com.example.backend.controller;

import com.example.backend.model.VirtualBuildOrder;
import com.example.backend.repository.VirtualBuildOrderRepository;
import com.example.backend.service.VirtualBuildOrderService;

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
import jakarta.transaction.Transactional;

@CrossOrigin(originPatterns = "*", maxAge = 3600)
@RestController
@RequestMapping("/virtual-build-order")
public class VirtualBuildOrderController {

  @Resource
  private VirtualBuildOrderRepository virtualBuildOrderRepository;

  @Resource
  private VirtualBuildOrderService virtualBuildOrderService;

  @GetMapping
  public List<VirtualBuildOrder> findAll() {
    return virtualBuildOrderRepository.findAll();
  }

  @PostMapping
  public void placeOrder(@RequestBody VirtualBuildOrder order) {
    virtualBuildOrderRepository.save(order);
  }

  @DeleteMapping("/{id}")
  public void deleteOrder(@PathVariable long id) {
    virtualBuildOrderService.deleteVirtualBuildWithComponents(id);
  }
}

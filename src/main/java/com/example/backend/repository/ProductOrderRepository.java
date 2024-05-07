package com.example.backend.repository;

import com.example.backend.model.ProductOrder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {
}

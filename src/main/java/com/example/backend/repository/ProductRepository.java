package com.example.backend.repository;

import com.example.backend.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

  List<Product> findAllByCategoryId(long categoryId);
}

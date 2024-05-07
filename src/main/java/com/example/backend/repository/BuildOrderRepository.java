package com.example.backend.repository;

import com.example.backend.model.BuildOrder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildOrderRepository extends JpaRepository<BuildOrder, Long> {
}

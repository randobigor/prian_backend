package com.example.backend.repository;

import com.example.backend.model.VirtualBuildOrder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VirtualBuildOrderRepository extends JpaRepository<VirtualBuildOrder, Long> {
}

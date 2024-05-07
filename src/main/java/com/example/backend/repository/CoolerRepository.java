package com.example.backend.repository;

import com.example.backend.model.Cooler;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.Column;

public interface CoolerRepository extends JpaRepository<Cooler, Long> {
}

package com.example.backend.repository;

import com.example.backend.model.Psu;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PsuRepository extends JpaRepository<Psu, Long> {
}

package com.example.backend.repository;

import com.example.backend.model.Gpu;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GpuRepository extends JpaRepository<Gpu, Long> {
}

package com.example.backend.repository;

import com.example.backend.model.Cpu;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CpuRepository extends JpaRepository<Cpu, Long> {

  List<Cpu> findAllBySocket(String socket);
}

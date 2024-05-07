package com.example.backend.repository;

import com.example.backend.model.Motherboard;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MotherboardRepository extends JpaRepository<Motherboard, Long> {

  List<Motherboard> findAllBySocket(String socket);

  List<Motherboard> findAllByRamType(String ramType);

  List<Motherboard> findAllBySocketAndRamType(String socket, String ramType);
}

package com.example.backend.repository;

import com.example.backend.model.Storage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<Storage, Long> {
}

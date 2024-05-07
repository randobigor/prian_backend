package com.example.backend.controller;

import com.example.backend.model.Storage;
import com.example.backend.repository.StorageRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import jakarta.annotation.Resource;

@CrossOrigin(originPatterns = "*", maxAge = 3600)
@RestController
@RequestMapping("/storage")
public class StorageController {

  @Resource
  private StorageRepository storageRepository;

  @GetMapping
  public List<Storage> getAllStorages() {
    return storageRepository.findAll();
  }

  @PostMapping
  public void addStorage(@RequestBody Storage storage) {
    storageRepository.save(storage);
  }
}

package com.example.backend.controller;

import com.example.backend.model.Cpu;
import com.example.backend.model.Memory;
import com.example.backend.repository.MemoryRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import jakarta.annotation.Resource;

@CrossOrigin(originPatterns = "*", maxAge = 3600)
@RestController
@RequestMapping("/memory")
public class MemoryController {

  @Resource
  private MemoryRepository memoryRepository;

  @GetMapping
  public List<Memory> getAllMemories() {
    return memoryRepository.findAll();
  }

  @PostMapping
  public void addMemory(@RequestBody Memory memory) {
    memoryRepository.save(memory);
  }

  @GetMapping("/by-type")
  public List<Memory> findAllBySocket(@RequestParam String type) {
    return memoryRepository.findAllByType(type);
  }
}

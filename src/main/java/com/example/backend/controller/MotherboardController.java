package com.example.backend.controller;

import com.example.backend.model.Motherboard;
import com.example.backend.repository.MotherboardRepository;

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
@RequestMapping("/motherboard")
public class MotherboardController {

  @Resource
  private MotherboardRepository motherboardRepository;

  @GetMapping
  public List<Motherboard> getAllMotherboards() {
    return motherboardRepository.findAll();
  }

  @PostMapping
  public void addMotherboard(@RequestBody Motherboard motherboard) {
    motherboardRepository.save(motherboard);
  }

  @GetMapping("/by-socket")
  public List<Motherboard> findAllBySocket(@RequestParam String socket) {
    return motherboardRepository.findAllBySocket(socket);
  }

  @GetMapping("/by-ram-type")
  public List<Motherboard> findAllByRamType(@RequestParam String ramType) {
    return motherboardRepository.findAllByRamType(ramType);
  }

  @GetMapping("/by-socket-and-ram-type")
  public List<Motherboard> findAllBySocketAndRamType(@RequestParam String socket, @RequestParam String ramType) {
    return motherboardRepository.findAllBySocketAndRamType(socket, ramType);
  }
}

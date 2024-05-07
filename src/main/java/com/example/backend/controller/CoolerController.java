package com.example.backend.controller;

import com.example.backend.model.Cooler;
import com.example.backend.repository.CoolerRepository;

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
@RequestMapping("/cooler")
public class CoolerController {

  @Resource
  private CoolerRepository coolerRepository;

  @GetMapping
  public List<Cooler> getAllCoolers() {
    return coolerRepository.findAll();
  }

  @PostMapping
  public void addCooler(@RequestBody Cooler cooler) {
    coolerRepository.save(cooler);
  }
}

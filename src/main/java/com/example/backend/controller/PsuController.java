package com.example.backend.controller;

import com.example.backend.model.Psu;
import com.example.backend.repository.PsuRepository;

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
@RequestMapping("/psu")
public class PsuController {

  @Resource
  private PsuRepository psuRepository;

  @GetMapping
  public List<Psu> getAllPsus() {
    return psuRepository.findAll();
  }

  @PostMapping
  public void addPsu(@RequestBody Psu psu) {
    psuRepository.save(psu);
  }
}

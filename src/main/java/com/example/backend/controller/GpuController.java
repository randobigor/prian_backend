package com.example.backend.controller;

import com.example.backend.model.Gpu;
import com.example.backend.repository.GpuRepository;

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
@RequestMapping("/gpu")
public class GpuController {

  @Resource
  private GpuRepository gpuRepository;

  @GetMapping
  public List<Gpu> getAllGpus() {
    return gpuRepository.findAll();
  }

  @PostMapping
  public void addGpu(@RequestBody Gpu gpu) {
    gpuRepository.save(gpu);
  }
}

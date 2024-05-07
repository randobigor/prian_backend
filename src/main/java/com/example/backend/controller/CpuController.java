package com.example.backend.controller;

import com.example.backend.model.Cpu;
import com.example.backend.repository.CpuRepository;

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
@RequestMapping("/cpu")
public class CpuController {

  @Resource
  private CpuRepository cpuRepository;

  @GetMapping
  public List<Cpu> getAllCpus() {
    return cpuRepository.findAll();
  }

  @PostMapping
  public void addCpu(@RequestBody Cpu cpu) {
    this.cpuRepository.save(cpu);
  }

  @GetMapping("/by-socket")
  public List<Cpu> findAllBySocket(@RequestParam String socket) {
    return cpuRepository.findAllBySocket(socket);
  }
}

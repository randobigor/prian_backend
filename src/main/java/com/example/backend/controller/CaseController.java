package com.example.backend.controller;

import com.example.backend.model.Case;
import com.example.backend.repository.CaseRepository;

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
@RequestMapping("/case")
public class CaseController {

  @Resource
  private CaseRepository caseRepository;

  @GetMapping
  public List<Case> getAllCases() {
    return caseRepository.findAll();
  }

  @PostMapping
  public void addCase(@RequestBody Case caseBody) {
    caseRepository.save(caseBody);
  }

}

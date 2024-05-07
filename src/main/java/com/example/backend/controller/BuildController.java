package com.example.backend.controller;

import com.example.backend.model.Build;
import com.example.backend.repository.BuildRepository;
import com.example.backend.specification.BuildSpecification;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import jakarta.annotation.Resource;

@CrossOrigin(originPatterns = "*", maxAge = 3600)
@RestController
@RequestMapping("/build")
public class BuildController {

  @Resource
  private BuildRepository buildRepository;

  @GetMapping
  public List<Build> getAllAvailableBuilds() {
    return buildRepository.findAllBySoldPriceIsNull();
  }

  @GetMapping("/{id}")
  public Build getBuildById(@PathVariable long id) {
    return buildRepository.findById(id).orElse(null);
  }

  @GetMapping("/by-filter")
  public List<Build> findAllBuildsByFilter() {
    String cpuVendor = "AMD";
    BuildSpecification spec = new BuildSpecification();
    spec.setCpuVendor(cpuVendor);

    return buildRepository.findAll(spec);
  }

  @PostMapping
  public void createProduct(@RequestBody Build build) {
    buildRepository.save(build);
  }

  @PutMapping("/sell-pc-build")
  public void sellPcBuild(@RequestParam long buildId, @RequestParam float soldPrice) {
    this.buildRepository.sellPcBuild(buildId, soldPrice);
  }


}

package com.example.backend.controller;

import com.example.backend.dto.SoldBuildDto;
import com.example.backend.service.StatisticService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import jakarta.annotation.Resource;

@CrossOrigin(originPatterns = "*", maxAge = 3600)
@RestController
@RequestMapping("/statistics")
public class StatisticsController {

  @Resource
  private StatisticService statisticService;

  @GetMapping("/products-count-by-group-by-category")
  public Map<String, Long> getProductsCountGroupByCategory() {
    return statisticService.getProductsCountGroupByCategory();
  }

  @GetMapping("/get-sold-builds")
  public List<SoldBuildDto> getSoldBuilds() {
    return statisticService.generateSoldBuilds();
  }
}

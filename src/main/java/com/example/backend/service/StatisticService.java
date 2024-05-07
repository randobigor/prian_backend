package com.example.backend.service;

import com.example.backend.dto.SoldBuildDto;
import com.example.backend.model.AdditionalCost;
import com.example.backend.model.Build;
import com.example.backend.model.Product;
import com.example.backend.repository.BuildRepository;
import com.example.backend.repository.ProductRepository;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.annotation.Resource;

@Component
public class StatisticService {

  @Resource
  private ProductRepository productRepository;

  @Resource
  private BuildRepository buildRepository;

  public Map<String, Long> getProductsCountGroupByCategory() {
    List<Product> products = productRepository.findAll();
    return products.stream().collect(Collectors.groupingBy(Product::getProductCategoryName, Collectors.counting()));
  }

  public List<SoldBuildDto> generateSoldBuilds() {
    List<Build> builds = buildRepository.findAllBySoldPriceIsNotNull();
    List<SoldBuildDto> soldBuilds = new ArrayList<>();

    for (Build build : builds) {
      SoldBuildDto tempBuild = new SoldBuildDto();

      tempBuild.setId(build.getId());
      tempBuild.setName(build.getName());
      tempBuild.setBuildPurpose(build.getBuildPurpose());
      tempBuild.setCpuVendor(build.getCpuVendor());
      tempBuild.setGpuVendor(build.getGpuVendor());
      tempBuild.setPrice(build.getPrice());
      tempBuild.setSoldPrice(build.getSoldPrice());
      tempBuild.setAdditionalCosts(calculateAdditionalCosts(build.getAdditionalCosts()));
      tempBuild.setProfit(build.getSoldPrice() - (build.getPrice() + tempBuild.getAdditionalCosts()));
      tempBuild.setSoldTerm(ChronoUnit.DAYS.between(build.getCreatedTm(), build.getSoldTm()));

      soldBuilds.add(tempBuild);
    }

    return soldBuilds;
  }

  private Float calculateAdditionalCosts(List<AdditionalCost> additionalCosts) {
    return additionalCosts.stream().map(AdditionalCost::getAmount).reduce(0f, Float::sum);
  }
}

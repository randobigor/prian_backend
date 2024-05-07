package com.example.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SoldBuildDto {
  private long id;
  private String name;
  private String buildPurpose;
  private String cpuVendor;
  private String gpuVendor;
  private Float price;
  private Float soldPrice;
  private Float profit;
  private Float additionalCosts;
  private long soldTerm;
}
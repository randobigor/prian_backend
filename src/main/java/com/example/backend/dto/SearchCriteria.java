package com.example.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchCriteria {
  private String cpuVendor;
  private String coolerType;
  private String gpuVendor;
  private String motherBoardSocket;
  private String ramType;
  private Integer ssdSize;
}

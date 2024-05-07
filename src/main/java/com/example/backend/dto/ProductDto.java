package com.example.backend.dto;

import com.example.backend.model.AdditionalCost;
import com.example.backend.model.Image;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {

  private long id;
  private String name;
  private String description;
  private long categoryId;
  private String stockAvailability;
  private float price;
  private String condition;
  private List<Image> images;
  private List<AdditionalCost> additionalCosts;

}

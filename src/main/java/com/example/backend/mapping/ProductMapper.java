package com.example.backend.mapping;

import com.example.backend.dto.ProductDto;
import com.example.backend.model.Product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

  @Mapping(source = "categoryId", target = "category.id")
  Product toEntity(ProductDto productDto);
}

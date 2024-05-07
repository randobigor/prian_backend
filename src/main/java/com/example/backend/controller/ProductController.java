package com.example.backend.controller;

import com.example.backend.dto.ProductDto;
import com.example.backend.mapping.ProductMapper;
import com.example.backend.model.Product;
import com.example.backend.repository.ProductRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import jakarta.annotation.Resource;

@CrossOrigin(originPatterns = "*", maxAge = 3600)
@RestController
@RequestMapping("/product")
public class ProductController {
  @Resource
  private ProductRepository productRepository;

  @Resource
  private ProductMapper productMapper;

  @GetMapping
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @GetMapping("/{productId}")
  public Product getProductById(@PathVariable long productId) {
    return productRepository.findById(productId).orElse(null);
  }

  @GetMapping("/category/{categoryId}")
  public List<Product> getAllProductsByCategoryId(@PathVariable long categoryId) {
    return productRepository.findAllByCategoryId(categoryId);
  }

  @PostMapping
  public void createProduct(@RequestBody ProductDto productDto) {
    productRepository.save(productMapper.toEntity(productDto));
  }

  @PutMapping
  public void updateProduct(@RequestBody ProductDto productDto) {
    productRepository.save(productMapper.toEntity(productDto));
  }

  @GetMapping("/products-by-category")
  public Map<String, Long> getProductsGroupByCategory() {
    List<Product> products = productRepository.findAll();

    Map<String, Long> map = products.stream().collect(Collectors.groupingBy(Product::getProductCategoryName, Collectors.counting()));

    return map;
  }
}

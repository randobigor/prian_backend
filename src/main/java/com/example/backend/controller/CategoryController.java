package com.example.backend.controller;

import com.example.backend.model.Category;
import com.example.backend.repository.CategoryRepository;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import jakarta.annotation.Resource;

@CrossOrigin(originPatterns = "*", maxAge = 3600)
@RestController
@RequestMapping("/categories")
public class CategoryController {

  @Resource
  private CategoryRepository categoryRepository;

  @GetMapping
  public List<Category> getAllCategories() {
    return categoryRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
  }

  @PostMapping
  public void createCategory(@RequestBody Category category) {
    categoryRepository.save(category);
  }

  @PutMapping
  public void updateCategory(@RequestBody Category category) {
    categoryRepository.save(category);
  }

  @DeleteMapping("/{id}")
  public void deleteCategory(@PathVariable long id) {
    categoryRepository.deleteById(id);
  }
}

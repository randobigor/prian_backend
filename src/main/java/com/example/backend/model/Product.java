package com.example.backend.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "price")
  private float price;

  @Column(name = "available")
  private boolean available;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "products_to_images",
      joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "image_id", referencedColumnName = "id")
  )
  private List<Image> images;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "products_to_costs",
      joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "cost_id", referencedColumnName = "id")
  )
  private List<AdditionalCost> additionalCosts;

  @Column(name = "stock_availability")
  private String stockAvailability;

  @Column(name = "condition")
  private String condition;

  @Transient
  public String getProductCategoryName() {
    return getCategory().getName();
  }

}

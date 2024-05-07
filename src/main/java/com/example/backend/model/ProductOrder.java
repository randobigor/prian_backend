package com.example.backend.model;

import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductOrder {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  @Column(name = "contact_name")
  private String contactName;

  @Column(name = "contact_number")
  private String contactNumber;

  @Column(name = "contact_email")
  private String contactEmail;

  @Column(name = "created_tm", updatable = false, insertable = false)
  private LocalDateTime createdTm;
}

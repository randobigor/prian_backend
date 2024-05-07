package com.example.backend.model;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private LocalDateTime createdTm;

  private String contactName;

  private String contactNumber;

  private String contactEmail;

  private long buildOrder;

  private long productOrder;
}

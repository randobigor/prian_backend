package com.example.backend.model;

import jakarta.persistence.CascadeType;
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
@Table(name = "cpus")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cpu {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "vendor", nullable = false)
  private String vendor;

  @Column(name = "model", nullable = false)
  private String model;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinColumn(name = "image_id")
  private Image image;

  @Column(name = "price", nullable = false)
  private Float price;

  @Column(name = "socket", nullable = false)
  private String socket;

  @Column(name = "cores", nullable = false)
  private int cores;

  @Column(name = "threads", nullable = false)
  private int threads;

  @Column(name = "freq", nullable = false)
  private int freq;

}

package com.example.backend.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

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
@Table(name = "virtual_build_orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VirtualBuildOrder {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "contact_name")
  private String contactName;

  @Column(name = "contact_number")
  private String contactNumber;

  @Column(name = "contact_email")
  private String contactEmail;

  @Column(name = "created_tm", updatable = false, insertable = false)
  private LocalDateTime createdTm;

  @JoinColumn(name = "cpu_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  @ManyToOne(cascade = {CascadeType.MERGE})
  private Cpu cpu;

  @JoinColumn(name = "cooler_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  @ManyToOne(cascade = {CascadeType.MERGE})
  private Cooler cooler;

  @JoinColumn(name = "motherboard_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  @ManyToOne(cascade = {CascadeType.MERGE})
  private Motherboard motherboard;

  @JoinColumn(name = "memory_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  @ManyToOne(cascade = {CascadeType.MERGE})
  private Memory memory;

  @JoinColumn(name = "storage_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  @ManyToOne(cascade = {CascadeType.MERGE})
  private Storage storage;

  @JoinColumn(name = "gpu_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  @ManyToOne(cascade = {CascadeType.MERGE})
  private Gpu gpu;

  @JoinColumn(name = "psu_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  @ManyToOne(cascade = {CascadeType.MERGE})
  private Psu psu;

  @JoinColumn(name = "case_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  @ManyToOne(cascade = {CascadeType.MERGE})
  private Case pcCase;
}

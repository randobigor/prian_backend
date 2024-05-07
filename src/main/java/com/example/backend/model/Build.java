package com.example.backend.model;

import java.time.LocalDateTime;
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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "builds")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Build {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "price")
  private Float price;

  @Column(name = "available")
  private boolean available;

  @Column(name = "created_tm", insertable = false, updatable = false)
  private LocalDateTime createdTm;

  @Column(name = "sold_price")
  private Float soldPrice;

  @Column(name = "show_price")
  private Float showPrice;

  @Column(name = "sold_tm")
  private LocalDateTime soldTm;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "builds_to_images",
      joinColumns = @JoinColumn(name = "builds_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "image_id", referencedColumnName = "id")
  )
  private List<Image> images;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "builds_to_costs",
      joinColumns = @JoinColumn(name = "build_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "cost_id", referencedColumnName = "id")
  )
  private List<AdditionalCost> additionalCosts;

  @Column(name = "stock_availability")
  private String stockAvailability;

  @Column(name = "condition")
  private String condition;

  @Column(name = "build_purpose")
  private String buildPurpose;

  @Column(name = "motherboard_name")
  private String motherBoardName;
  @Column(name = "motherboard_chipset")
  private String motherBoardChipset;
  @Column(name = "motherboard_socket")
  private String motherBoardSocket;

  @Column(name = "cpu_vendor")
  private String cpuVendor;
  @Column(name = "cpu_model")
  private String cpuModel;
  @Column(name = "cpu_cores")
  private int cpuCores;
  @Column(name = "cpu_threads")
  private int cpuThreads;
  @Column(name = "cpu_freq")
  private int cpuFreq;

  @Column(name = "cooler_type")
  private String coolerType;
  @Column(name = "cooler_name")
  private String coolerName;

  @Column(name = "ram_model")
  private String ramModel;
  @Column(name = "ram_type")
  private String ramType;
  @Column(name = "ram_freq")
  private int ramFreq;
  @Column(name = "ram_size")
  private int ramSize;
  @Column(name = "ram_stick_number")
  private int ramStickNumber;

  @Column(name = "rom_ssd_name")
  private String romSsdName;
  @Column(name = "rom_ssd_capacity")
  private int romSsdCapacity;
  @Column(name = "rom_hdd_name")
  private String romHddName;
  @Column(name = "rom_hdd_capacity")
  private int romHddCapacity;

  @Column(name = "gpu_vendor")
  private String gpuVendor;
  @Column(name = "gpu_model")
  private String gpuModel;
  @Column(name = "gpu_capacity")
  private int gpuCapacity;
  @Column(name = "gpu_memory_type")
  private String gpuMemoryType;

  @Column(name = "psu_name")
  private String psuName;
  @Column(name = "psu_model")
  private String psuModel;
  @Column(name = "psu_power")
  private int psuPower;
  @Column(name = "psu_certificate")
  private String psuCertificate;

  @Column(name = "case_name")
  private String caseName;
  @Column(name = "case_model")
  private String caseModel;
  @Column(name = "case_form_factor")
  private String caseFormFactor;
}

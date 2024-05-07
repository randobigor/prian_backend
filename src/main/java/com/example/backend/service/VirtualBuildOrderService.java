package com.example.backend.service;

import com.example.backend.model.VirtualBuildOrder;
import com.example.backend.repository.CaseRepository;
import com.example.backend.repository.CoolerRepository;
import com.example.backend.repository.CpuRepository;
import com.example.backend.repository.GpuRepository;
import com.example.backend.repository.MemoryRepository;
import com.example.backend.repository.MotherboardRepository;
import com.example.backend.repository.PsuRepository;
import com.example.backend.repository.StorageRepository;
import com.example.backend.repository.VirtualBuildOrderRepository;

import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;

@Component
public class VirtualBuildOrderService {

  @Resource
  private CpuRepository cpuRepository;

  @Resource
  private CoolerRepository coolerRepository;

  @Resource
  private MotherboardRepository motherboardRepository;

  @Resource
  private MemoryRepository memoryRepository;

  @Resource
  private StorageRepository storageRepository;

  @Resource
  private GpuRepository gpuRepository;

  @Resource
  private PsuRepository psuRepository;

  @Resource
  private CaseRepository caseRepository;

  @Resource
  private VirtualBuildOrderRepository virtualBuildOrderRepository;


  @Transactional
  public void deleteVirtualBuildWithComponents(long buildOrderId) {
    VirtualBuildOrder order = virtualBuildOrderRepository.findById(buildOrderId).orElse(null);
    virtualBuildOrderRepository.delete(order);

    cpuRepository.deleteById(order.getCpu().getId());
    coolerRepository.deleteById(order.getCooler().getId());
    motherboardRepository.deleteById(order.getMotherboard().getId());
    memoryRepository.deleteById(order.getMemory().getId());
    storageRepository.deleteById(order.getStorage().getId());
    gpuRepository.deleteById(order.getGpu().getId());
    psuRepository.deleteById(order.getPsu().getId());
    caseRepository.deleteById(order.getPcCase().getId());
  }
}

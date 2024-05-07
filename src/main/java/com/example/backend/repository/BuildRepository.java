package com.example.backend.repository;

import com.example.backend.model.Build;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import jakarta.transaction.Transactional;

public interface BuildRepository extends JpaRepository<Build, Long>, JpaSpecificationExecutor<Build> {

  @Modifying
  @Transactional
  @Query("update Build b set b.soldPrice = :sold_price, b.soldTm = CURRENT_TIMESTAMP, b.available = false where b.id = :id")
  void sellPcBuild(@Param(value = "id") long id, @Param(value = "sold_price") Float soldPrice);

  List<Build> findAllBySoldPriceIsNotNull();

  List<Build> findAllBySoldPriceIsNull();
}

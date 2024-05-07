package com.example.backend.specification;

import com.example.backend.model.Build;
import com.example.backend.model.Build_;

import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BuildSpecification implements Specification<Build> {

  private String cpuVendor;

  @Override
  public Predicate toPredicate(Root<Build> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
    List<Predicate> predicates = new ArrayList<>();

    if (cpuVendor != null) {
      predicates.add(criteriaBuilder.equal(root.get(Build_.CPU_VENDOR), cpuVendor));
    }

    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
  }

//  public static BuildSpecification
}
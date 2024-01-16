package com.qualcoTest.CountriesApi.infrastructure.rdbms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "region_areas")
public class RegionArea {

  @Id
  @Column(nullable = false, columnDefinition = "VARCHAR(100)")
  private String regionName;
  @Column(nullable = false, columnDefinition = "Decimal(15,2)")
  private double regionArea;
}

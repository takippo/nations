package com.qualcoTest.CountriesApi.infrastructure.rdbms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "country_stats")
@IdClass(CountyStatsId.class)
public class CountryStats {

  @Id
  @Column(name = "year", updatable = false, unique = true)
  private int year;

  private int population;
  @Column(columnDefinition = "Decimal(15,0)")
  private double gdp;


  @Id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "country_id")
  private Country country;

}

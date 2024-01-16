package com.qualcoTest.CountriesApi.infrastructure.rdbms.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "regions")
public class Region {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int regionId;

  @Column(nullable = false, columnDefinition = "varchar(100)")
  private String name;

  @OneToMany(
      mappedBy = "region",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private List<Country> countries = new ArrayList<>();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "continent_id", nullable = false)
  private Continent continent;

  public void addCountry(Country country){
    countries.add(country);
    country.setRegion(this);
  }

  public void removeCountry(Country country){
    countries.remove(country);
    country.setRegion(null);
  }

}

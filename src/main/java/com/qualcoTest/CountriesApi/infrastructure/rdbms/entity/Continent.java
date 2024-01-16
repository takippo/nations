package com.qualcoTest.CountriesApi.infrastructure.rdbms.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "continents")
public class Continent {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int continentId;
  @Column(nullable = false)
  private String name;

  @OneToMany(
      mappedBy = "continent",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private List<Region> regions = new ArrayList<>();

  public void addRegion(Region region){
    regions.add(region);
    region.setContinent(this);
  }

  public void removeRegion(Region region){
    regions.remove(region);
    region.setContinent(null);
  }
}

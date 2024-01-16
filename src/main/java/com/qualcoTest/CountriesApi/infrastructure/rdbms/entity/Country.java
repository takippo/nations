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
import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
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
@Table(name = "countries")
public class Country {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int countryId;
  private String name;
  @Column(nullable = false, columnDefinition = "Decimal(10,2)")
  private double area;
  private Date nationalDay;
  @Column(nullable = false,unique = true, columnDefinition = "CHAR(2)")
  private String countryCode2;
  @Column(nullable = false,unique = true, columnDefinition = "CHAR(3)")
  private String countryCode3;


  @OneToMany(
      mappedBy = "country",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private List<CountryStats> countryStats = new ArrayList<>();

  @OneToMany(
      mappedBy = "country",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private List<CountryLanguage> countryLanguages = new ArrayList<>();


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "region_id")
  private Region region;

  public void addCountryStats(CountryStats countryStats) {
    this.countryStats.add(countryStats);
    countryStats.setCountry(this);
  }

  public void removeCountryStats(CountryStats countryStats) {
    this.countryStats.remove(countryStats);
    countryStats.setCountry(null);
  }

  public void addCountryLanguage(CountryLanguage countryLanguage) {
    this.countryLanguages.add(countryLanguage);
    countryLanguage.setCountry(this);
  }

  public void removeCountryLanguage(CountryLanguage countryLanguage)  {
    this.countryLanguages.remove(countryLanguage);
    countryLanguage.setCountry(null);
  }


  public CountryStats yearWithBiggerGdpPopulationRation(){
    return this.countryStats.stream().max((cL1, cL2)-> {
      if ((cL1.getGdp()/cL1.getPopulation()) < (cL2.getGdp()/cL2.getPopulation())){
        return -1;
      }else if((cL1.getGdp()/cL1.getPopulation()) == (cL2.getGdp()/cL2.getPopulation())){
        return 0;
      }else{
        return 1;
      }
    } ).orElse(new CountryStats());
  }

}

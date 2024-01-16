package com.qualcoTest.CountriesApi.domain.dto;

import com.qualcoTest.CountriesApi.infrastructure.rdbms.entity.CountryLanguage;
import com.qualcoTest.CountriesApi.infrastructure.rdbms.entity.CountryStats;
import com.qualcoTest.CountriesApi.infrastructure.rdbms.entity.Region;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CountryDto {

  private int id;
  private String name;
  private double area;
  private String countryCode3;
  private String countryCode2;
  private List<String> languages;
  private CountryStatsDto CountryStats;
  private String region;
  private String continent;
}

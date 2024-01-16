package com.qualcoTest.CountriesApi.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CountryStatsDto {

  private int year;
  private int population;
  private double gdp;
}

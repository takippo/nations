package com.qualcoTest.CountriesApi.infrastructure.rdbms.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountyStatsId implements Serializable {

  private int year;
  private Country country;

}

package com.qualcoTest.CountriesApi.infrastructure.rdbms.entity;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CountryLanguageId implements Serializable {

  private Country country;

  private Language language;

}

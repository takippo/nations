package com.qualcoTest.CountriesApi.domain.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Criteria {

  private List<String> regions;
  private int dateFrom;
  private int dateTo;
}

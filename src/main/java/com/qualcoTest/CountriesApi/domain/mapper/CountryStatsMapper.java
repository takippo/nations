package com.qualcoTest.CountriesApi.domain.mapper;

import com.qualcoTest.CountriesApi.domain.dto.CountryStatsDto;
import com.qualcoTest.CountriesApi.infrastructure.rdbms.entity.CountryStats;
import org.springframework.stereotype.Component;

@Component
public class CountryStatsMapper implements Mapper<CountryStats,CountryStatsDto> {

  @Override
  public CountryStatsDto mapTo(CountryStats countryStats) {
    var dto = new CountryStatsDto();
    dto.setYear(countryStats.getYear());
    dto.setGdp(countryStats.getGdp());
    dto.setPopulation(countryStats.getPopulation());
    return dto;
  }

  @Override
  public CountryStats mapFrom(CountryStatsDto countryStatsDto) {
    return null;
  }
}

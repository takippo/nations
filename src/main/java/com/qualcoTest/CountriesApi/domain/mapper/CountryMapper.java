package com.qualcoTest.CountriesApi.domain.mapper;

import com.qualcoTest.CountriesApi.domain.dto.CountryDto;
import com.qualcoTest.CountriesApi.infrastructure.rdbms.entity.Country;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CountryMapper implements Mapper<Country, CountryDto> {

  private final CountryStatsMapper countryStatsMapper;
  @Override
  public CountryDto mapTo(Country country) {
    var dto = new CountryDto();
    dto.setId(country.getCountryId());
    dto.setName(country.getName());
    dto.setArea(country.getArea());
    dto.setCountryCode2(country.getCountryCode2());
    dto.setCountryCode3(country.getCountryCode3());
    dto.setLanguages(country.getCountryLanguages().stream().map(countryLanguage -> countryLanguage.getLanguage().getLanguage()).collect(Collectors.toList()));
    dto.setCountryStats(countryStatsMapper.mapTo(country.yearWithBiggerGdpPopulationRation()));
    return dto;
  }

  @Override
  public Country mapFrom(CountryDto countryDto) {
    return null;
  }
}

package com.qualcoTest.CountriesApi.domain.service;

import com.qualcoTest.CountriesApi.infrastructure.rdbms.entity.Country;
import com.qualcoTest.CountriesApi.infrastructure.rdbms.repository.CountryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService{

  private final CountryRepository countryRepository;
  @Override
  public List<Country> getCountries() {
    return countryRepository.findAllByOrderByNameAsc();
  }
}

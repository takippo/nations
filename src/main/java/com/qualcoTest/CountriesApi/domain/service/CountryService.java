package com.qualcoTest.CountriesApi.domain.service;

import com.qualcoTest.CountriesApi.domain.dto.Criteria;
import com.qualcoTest.CountriesApi.infrastructure.rdbms.entity.Country;
import java.util.List;

public interface CountryService {

  List<Country> getCountries();

  List<Country> getCountries(Criteria criteria);
}

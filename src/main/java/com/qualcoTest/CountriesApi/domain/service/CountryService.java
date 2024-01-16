package com.qualcoTest.CountriesApi.domain.service;

import com.qualcoTest.CountriesApi.infrastructure.rdbms.entity.Country;
import java.util.List;

public interface CountryService {

  List<Country> getCountries();

}

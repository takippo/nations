package com.qualcoTest.CountriesApi.application.controller;

import com.qualcoTest.CountriesApi.domain.dto.CountryDto;
import com.qualcoTest.CountriesApi.domain.dto.Criteria;
import com.qualcoTest.CountriesApi.domain.mapper.CountryMapper;
import com.qualcoTest.CountriesApi.domain.service.CountryService;
import com.qualcoTest.CountriesApi.infrastructure.rdbms.entity.Country;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/countries")
@RequiredArgsConstructor
public class CountryController {

  private final CountryService countryService;
  private final CountryMapper countryMapper;

  @GetMapping
  @CrossOrigin
  //TODO: ADD PAGINATION
  //TODO: EXCEPTION HANDLING
  public ResponseEntity<List<CountryDto>> getCountries(@RequestBody(required = false) Criteria criteria){
    var countries  = countryService.getCountries(criteria);
    var countriesDtos = countries.stream().map(countryMapper::mapTo).collect(
        Collectors.toList());
    return ResponseEntity.ok(countriesDtos);
  }
}

package com.qualcoTest.CountriesApi.infrastructure.rdbms.repository;

import com.qualcoTest.CountriesApi.infrastructure.rdbms.entity.Country;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CountryRepository extends JpaRepository<Country, Integer> {

  List<Country> findAllByOrderByNameAsc();
}

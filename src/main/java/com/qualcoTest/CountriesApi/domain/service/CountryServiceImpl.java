package com.qualcoTest.CountriesApi.domain.service;

import static java.util.Objects.nonNull;

import com.qualcoTest.CountriesApi.domain.dto.Criteria;
import com.qualcoTest.CountriesApi.infrastructure.rdbms.entity.Continent;
import com.qualcoTest.CountriesApi.infrastructure.rdbms.entity.Country;
import com.qualcoTest.CountriesApi.infrastructure.rdbms.entity.CountryStats;
import com.qualcoTest.CountriesApi.infrastructure.rdbms.entity.Region;
import com.qualcoTest.CountriesApi.infrastructure.rdbms.repository.CountryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService{

  private final EntityManager entityManager;
  private final CountryRepository countryRepository;
  @Override
  public List<Country> getCountries() {
    return countryRepository.findAllByOrderByNameAsc();
  }

  @Override
  public List<Country> getCountries(Criteria criteria) {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Country> cq = cb.createQuery(Country.class);

    Root<Country> countryRoot = cq.from(Country.class);
    Join<Country, Region> regionJoin = countryRoot.join("region", JoinType.RIGHT);
    Join<Country, CountryStats> statsJoin = countryRoot.join("countryStats", JoinType.LEFT);
    Join<Region, Continent> regionContinentJoin = regionJoin.join("continent", JoinType.INNER);

    cq.where(buildQueryPredicates(countryRoot, regionJoin, statsJoin, criteria));

    TypedQuery<Country> query = entityManager.createQuery(cq);
    return query.getResultList();
  }

  private Predicate[] buildQueryPredicates(
      Root<Country> countryRoot,
      Join<Country, Region> regionJoin,
      Join<Country, CountryStats> statsJoin,
      Criteria criteria) {
    var criteriaBuilder = entityManager.getCriteriaBuilder();

    List<Predicate> predicates = new ArrayList<>();

    if (criteria == null) {
      return predicates.toArray(new Predicate[0]);
    }

    if (nonNull(criteria.getRegions()) && !criteria.getRegions().isEmpty()) {
      predicates.add(regionJoin.get("name").in(criteria.getRegions()));
    }

    predicates.add( criteriaBuilder.between(
        statsJoin.get("year"),
        criteria.getDateFrom(),
        criteria.getDateTo()));

    return predicates.toArray(new Predicate[0]);
  }
}

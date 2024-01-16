package com.qualcoTest.CountriesApi.domain.mapper;

public interface Mapper<T,U> {

  public U mapTo(T t);

  public T mapFrom(U u);

}

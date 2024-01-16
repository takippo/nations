package com.qualcoTest.CountriesApi.infrastructure.configuration;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static org.modelmapper.convention.MatchingStrategies.STRICT;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
@Configuration
public class AppConfig {

  @Bean
  @Primary
  public ObjectMapper objectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.disable(FAIL_ON_UNKNOWN_PROPERTIES);
    objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    return objectMapper;
  }

  @Bean
  @Primary
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    //modelMapper.getConfiguration().setMatchingStrategy(STRICT);
    return modelMapper;
  }

}

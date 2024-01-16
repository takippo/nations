package com.qualcoTest.CountriesApi.infrastructure.rdbms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "guests")
public class Guest {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int guestId;
  @Column(nullable = false, columnDefinition = "VARCHAR(100)")
  private String name;
}

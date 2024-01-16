package com.qualcoTest.CountriesApi.infrastructure.rdbms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "vips")
public class Vip {

  @Id
  private int vipId;
  @Column(nullable = false, columnDefinition = "varchar(100)")
  private String name;

}

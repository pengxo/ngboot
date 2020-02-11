package com.pengxo.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pengxo.database.entity.onetomany.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}

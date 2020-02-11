package com.pengxo.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pengxo.database.entity.onetomany.Province;

public interface ProvinceRepository extends JpaRepository<Province, Long> {

}

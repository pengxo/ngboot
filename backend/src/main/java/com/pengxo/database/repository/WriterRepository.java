package com.pengxo.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pengxo.database.entity.manytomany.Writer;

public interface WriterRepository extends JpaRepository<Writer, Long> {

}

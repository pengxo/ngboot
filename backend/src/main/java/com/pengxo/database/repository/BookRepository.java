package com.pengxo.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pengxo.database.entity.manytomany.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}

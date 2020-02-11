package com.pengxo.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pengxo.database.entity.manytomany.Book;
import com.pengxo.database.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Transactional
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Transactional
	public void saveBook(final Book book) {
		bookRepository.save(book);
	}

	@Transactional
	public void deleteBook(final Book book) {
		bookRepository.delete(book);
	}

	@Transactional
	public Book findById(final Long id) {
		return bookRepository.findById(id).orElse(null);
	}

}

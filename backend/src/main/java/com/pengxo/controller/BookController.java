package com.pengxo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pengxo.database.entity.manytomany.Book;
import com.pengxo.database.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping(path = "/books")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@PostMapping(path = "/addBook")
	public void addBook(@RequestBody final Book book) {
		bookService.saveBook(book);
	}

	@PostMapping(path = "/editBook")
	public void editBook(@RequestBody final Book book) {
		bookService.saveBook(book);
	}

	@DeleteMapping(path = "/deleteBook")
	public void removeBook(@RequestBody final Book book) {
		bookService.deleteBook(book);
	}

}

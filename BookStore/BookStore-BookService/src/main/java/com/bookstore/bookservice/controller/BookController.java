package com.bookstore.bookservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bookservice.model.Book;
import com.bookstore.bookservice.service.BookService;

@RestController
@RequestMapping(value = "/api/books")
public class BookController {
	
	@Autowired 
	private BookService service;
	
	@GetMapping
	public List<Book> getAllBooks(){
		return service.getAllBooks();
	}
	
	@GetMapping(value = "/{id}")
	public Book getBookById(@PathVariable Long id) {
		return service.getBookById(id);
	}
	
	@PostMapping
	public Book addBook(@RequestBody Book book) {
		return service.createBook(book);
	}
	
	@PutMapping(value = "/{id}")
	public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
		return service.updateBook(book);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
	    service.deleteBook(id);
	    return ResponseEntity.noContent().build();
	}

}

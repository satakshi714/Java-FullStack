package com.bookstore.orderservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.orderservice.dto.BookDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name = "book-service", path = "/api/books")
public interface BookClient {
	
	@GetMapping
	public List<BookDTO> getAllBooks();
	
	@GetMapping(value = "/{id}")
	public BookDTO getBookById(@PathVariable Long id);
	
	@PostMapping
	public BookDTO createBook(@RequestBody BookDTO book);
	
	@PutMapping(value = "/{id}")
	public BookDTO updateBook(@PathVariable Long id, @RequestBody BookDTO book);
	
	@DeleteMapping(value = "/{id}")
	public void deleteBook(@PathVariable Long id);
}

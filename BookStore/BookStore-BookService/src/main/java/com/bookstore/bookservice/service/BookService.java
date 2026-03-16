package com.bookstore.bookservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookservice.model.Book;
import com.bookstore.bookservice.repository.BookServiceRepository;

@Service
public class BookService {
	
	@Autowired
	BookServiceRepository bookSerRep;
	
	public List<Book> getAllBooks(){
		return bookSerRep.findAll();
	}
	
	public Book getBookById(Long id) {
		return bookSerRep.findById(id).get();
	}
	
	public Book createBook(Book book) {
		return bookSerRep.save(book);
	}
	
	public Book updateBook(Book book) {
		return bookSerRep.save(book);
	}
	
	public void deleteBook(Long id) {
		bookSerRep.deleteById(id);
	}

}

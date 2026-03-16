package com.bookstore.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.bookservice.model.Book;

public interface BookServiceRepository extends JpaRepository<Book, Long>{

}

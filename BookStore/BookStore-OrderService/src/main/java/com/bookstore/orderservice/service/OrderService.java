package com.bookstore.orderservice.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.orderservice.client.BookClient;
import com.bookstore.orderservice.dto.BookDTO;
import com.bookstore.orderservice.model.Order;
import com.bookstore.orderservice.repository.OrderServiceRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderServiceRepository orderSerRep;
	
	@Autowired 
	BookClient client;
	
	public List<Order> getAllOrders(){
		return orderSerRep.findAll();
	}
	
	public Order getOrderById(Long id) {
		return orderSerRep.findById(id).get();
	}
	
	public Order createOrder(Order order) {
		BookDTO book = client.getBookById(order.getBookId());
		order.setTotalPrice(book.getPrice() * order.getQuantity());
		order.setOrderDate(LocalDate.now());
		return orderSerRep.save(order);
	}
	
	public Order updateOrder(Order order) {
		return orderSerRep.save(order);
	}
	
	public void deleteOrder(Long id) {
		orderSerRep.deleteById(id);
	}

}

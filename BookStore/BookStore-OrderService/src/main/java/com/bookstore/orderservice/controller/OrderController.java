package com.bookstore.orderservice.controller;

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

import com.bookstore.orderservice.model.Order;
import com.bookstore.orderservice.service.OrderService;

@RestController
@RequestMapping(value = "/api/orders")
public class OrderController {
	
	@Autowired 
	private OrderService service;
	
	@GetMapping
	public List<Order> getAllOrders(){
		return service.getAllOrders();
	}
	
	@GetMapping(value = "/{id}")
	public Order getOrderById(@PathVariable Long id) {
		return service.getOrderById(id);
	}
	
	@PostMapping
	public Order addOrder(@RequestBody Order order) {
		return service.createOrder(order);
	}
	
	@PutMapping(value = "/{id}")
	public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
		return service.updateOrder(order);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
	    service.deleteOrder(id);
	    return ResponseEntity.noContent().build();
	}

}

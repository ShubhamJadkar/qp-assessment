package com.groceryapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groceryapi.entity.GroceryItem;

import com.groceryapi.entity.OrderItem;
import com.groceryapi.entity.Orders;
import com.groceryapi.service.GroceryService;

import jakarta.persistence.criteria.Order;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private GroceryService groceryService;

    @GetMapping("/groceries")
    public ResponseEntity<List<GroceryItem>> getAvailableGroceries() {
        return ResponseEntity.ok(groceryService.getAllGroceryItems());
    }

    @PostMapping("/orders")
    public ResponseEntity<Orders> placeOrder(@RequestBody List<OrderItem> items) {
        return ResponseEntity.ok(groceryService.placeOrder(items));
    }
}
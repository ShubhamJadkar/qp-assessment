package com.groceryapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groceryapi.entity.GroceryItem;
import com.groceryapi.service.GroceryService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private GroceryService groceryService;

    @PostMapping("/groceries")
    public ResponseEntity<GroceryItem> addGroceryItem(@RequestBody GroceryItem item) {
        return ResponseEntity.ok(groceryService.addGroceryItem(item));
    }

    @GetMapping("/groceries")
    public ResponseEntity<List<GroceryItem>> getAllGroceryItems() {
        return ResponseEntity.ok(groceryService.getAllGroceryItems());
    }

    @DeleteMapping("/groceries/{id}")
    public ResponseEntity<Void> deleteGroceryItem(@PathVariable Long id) {
        groceryService.deleteGroceryItem(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/groceries/{id}")
    public ResponseEntity<GroceryItem> updateGroceryItem(@PathVariable Long id, @RequestBody GroceryItem item) {
        return ResponseEntity.ok(groceryService.updateGroceryItem(id, item));
    }

    @PatchMapping("/groceries/{id}/inventory")
    public ResponseEntity<GroceryItem> updateInventory(@PathVariable Long id, @RequestBody int quantity) {
        return ResponseEntity.ok(groceryService.updateInventory(id, quantity));
    }
}


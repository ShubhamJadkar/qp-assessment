package com.groceryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groceryapi.entity.GroceryItem;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long>{

	GroceryItem save(GroceryItem item);

}

package com.groceryapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groceryapi.entity.GroceryItem;
import com.groceryapi.entity.OrderItem;
import com.groceryapi.entity.Orders;
import com.groceryapi.repository.GroceryItemRepository;
import com.groceryapi.repository.OrderRepository;

@Service
	public class GroceryService {

	    @Autowired
	    private GroceryItemRepository groceryItemRepository;

	    @Autowired
	    private OrderRepository orderRepository;

	    public GroceryItem addGroceryItem(GroceryItem item) {
	        return groceryItemRepository.save(item);
	    }

	    public List<GroceryItem> getAllGroceryItems() {
	        return groceryItemRepository.findAll();
	    }

	    public void deleteGroceryItem(Long id) {
	        groceryItemRepository.deleteById(id);
	    }

	    public GroceryItem updateGroceryItem(Long id, GroceryItem item) {
	        return groceryItemRepository.findById(id)
	                .map(existing -> {
	                    existing.setName(item.getName());
	                    existing.setPrice(item.getPrice());
	                    existing.setQuantity(item.getQuantity());
	                    return groceryItemRepository.save(existing);
	                })
	                .orElseThrow(() -> new RuntimeException("Item not found"));
	    }

	    public GroceryItem updateInventory(Long id, int quantity) {
	        return groceryItemRepository.findById(id)
	                .map(item -> {
	                    item.setQuantity(quantity);
	                    return groceryItemRepository.save(item);
	                })
	                .orElseThrow(() -> new RuntimeException("Item not found"));
	    }

	    public Orders placeOrder(List<OrderItem> items) {
	        double totalPrice = items.stream()
	                .mapToDouble(orderItem -> {
	                    GroceryItem item = groceryItemRepository.findById(orderItem.getGroceryItemId())
	                            .orElseThrow(() -> new RuntimeException("Item not found"));
	                    if (item.getQuantity() < orderItem.getQuantity()) {
	                        throw new RuntimeException("Insufficient stock for item: " + item.getName());
	                    }
	                    item.setQuantity(item.getQuantity() - orderItem.getQuantity());
	                    groceryItemRepository.save(item);
	                    return item.getPrice() * orderItem.getQuantity();
	                })
	                .sum();

	        Orders order = new Orders();
	        order.setItems(items);
	        order.setTotalPrice(totalPrice);
	        return orderRepository.save(order);
	    }
	

}

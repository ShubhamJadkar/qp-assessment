package com.groceryapi.entity;


import jakarta.persistence.*;
import java.util.List;


@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<OrderItem> items;

    private double totalPrice;

   
    public Long getId() { 
    	
    	return id; 
    	
    }
    public void setId(Long id)
    {
    	this.id = id;
    }
    
    public List<OrderItem> getItems()
    { 
    	return items; 
    }
    public void setItems(List<OrderItem> items)
    {
    	this.items = items; 
    }
    public double getTotalPrice()
    { 
    	return totalPrice; 
    }
    public void setTotalPrice(double totalPrice) { 
    	
    	this.totalPrice = totalPrice;
    	
    }
}
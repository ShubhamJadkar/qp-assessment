package com.groceryapi.entity;

import jakarta.persistence.Embeddable;

@Embeddable
	public class OrderItem {
	
	    private Long groceryItemId;
	    private int quantity;
		public Long getGroceryItemId() {
			return groceryItemId;
		}
		public void setGroceryItemId(Long groceryItemId) {
			this.groceryItemId = groceryItemId;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

	

}

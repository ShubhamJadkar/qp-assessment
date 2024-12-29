package com.groceryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.groceryapi.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

}

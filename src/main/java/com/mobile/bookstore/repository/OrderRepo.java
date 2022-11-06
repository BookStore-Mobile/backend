package com.mobile.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mobile.bookstore.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository <Order, Integer>{

	@Query("SELECT o FROM Order o WHERE o.id = :id")
	Order findOrderById(@Param("id") Integer id);
}

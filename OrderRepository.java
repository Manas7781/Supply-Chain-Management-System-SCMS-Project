package com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findByCustomerId(Long customerId);

	Optional<Order >findByTrackingNumber(String trackingNumber);
}

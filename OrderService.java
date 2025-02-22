package com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.service;

import java.util.List;


import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.dto.OrderDTO;

public interface OrderService {

	    OrderDTO createOrder(OrderDTO orderDto);
	    OrderDTO getOrderById(Long id);
	    List<OrderDTO> getAllOrder();
	    List<OrderDTO> getOrderByCustomerId(Long customerId);
	    OrderDTO getOrderByTrackingNumber(String trackingNumber);
	    OrderDTO updateOrder(Long id, OrderDTO orderDto);
	    void deleteOrder(Long id);
	    
	}

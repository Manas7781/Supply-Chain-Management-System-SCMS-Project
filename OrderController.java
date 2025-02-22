package com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.service;

import java.util.List;




import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.dto.OrderDTO;

@RestController
@RequestMapping("/api/orders")

public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/createOrder")
	public OrderDTO createOrder(@RequestBody OrderDTO orderDto) {
		return orderService.createOrder(orderDto);
	}

	@GetMapping("/{id}")
	public OrderDTO getOrderById(@PathVariable Long id) {
		return orderService.getOrderById(id);
	}

	@GetMapping
	public List<OrderDTO> getAllOrder() {
		return orderService.getAllOrder();
	}

	@GetMapping("/customer/{customerId}")
	public List<OrderDTO> getOrderByCustomerId(@PathVariable Long customerId) {
		return orderService.getOrderByCustomerId(customerId);
	}

	@GetMapping("/tracking/{trackingNumber}")
	public OrderDTO getOrderByTrackingNumber(@PathVariable String trackingNumber) {
		return orderService.getOrderByTrackingNumber(trackingNumber);
	}

	@PutMapping("/{id}")
	public OrderDTO updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDto) {
		return orderService.updateOrder(id, orderDto);
	}

	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable Long id) {
		orderService.deleteOrder(id);
	}
}

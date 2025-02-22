package com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.service;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.dto.OrderDTO;
import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.dto.OrderDTO;
import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.entity.Customer;
import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.entity.Order;
import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.repository.CustomerRepository;
import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.repository.OrderRepository;

@Service
	public class OrderServiceImplementation implements OrderService {

	    @Autowired
	    private OrderRepository orderRepository;

	    @Autowired
	    private CustomerRepository customerRepository;

	    @Autowired
	    private ModelMapper modelMapper;

	    public OrderDTO createOrder(OrderDTO orderDto) {
	        Customer customer = customerRepository.findById(orderDto.getCustomerId())
	                .orElseThrow(() -> new RuntimeException("Customer not found"));
	        Order order = modelMapper.map(orderDto, Order.class);
	        order.setCustomer(customer);
	        Order savedOrder = orderRepository.save(order);
	        return modelMapper.map(savedOrder, OrderDTO.class);
	    }

	    @Override
	    public OrderDTO getOrderById(Long id) {
	        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
	        return modelMapper.map(order, OrderDTO.class);
	    }

	    @Override
	    public List<OrderDTO> getAllOrder() {
	        return orderRepository.findAll().stream()
	                .map(order -> modelMapper.map(order, OrderDTO.class))
	                .collect(Collectors.toList());
	    }

	    @Override
	    public List<OrderDTO> getOrderByCustomerId(Long customerId) {
	        return orderRepository.findByCustomerId(customerId).stream()
	                .map(order -> modelMapper.map(order, OrderDTO.class))
	                .collect(Collectors.toList());
	    }

	    @Override
	    public OrderDTO getOrderByTrackingNumber(String trackingNumber) {
	        Order order = orderRepository.findByTrackingNumber(trackingNumber)
	                .orElseThrow(() -> new RuntimeException("Order not found"));
	        return modelMapper.map(order, OrderDTO.class);
	    }

	    @Override
	    public OrderDTO updateOrder(Long id, OrderDTO orderDto) {
	        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
	        modelMapper.map(orderDto, order);
	        Order updatedOrder = orderRepository.save(order);
	        return modelMapper.map(updatedOrder, OrderDTO.class);
	    }

	    @Override
	    public void deleteOrder(Long id) {
	        orderRepository.deleteById(id);
	    }
	}


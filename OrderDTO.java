package com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.dto;

import java.time.LocalDate;
import java.util.List;

public class OrderDTO {
	
	private Long id;
	private LocalDate orderDate;
	private Double totalAmount;
	private String status;
	private String trackingNumber;
	private Long customerId;
	private List<Integer>productId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public List<Integer> getProductId() {
		return productId;
	}
	public void setProductId(List<Integer> productId) {
		this.productId = productId;
	}
	
}

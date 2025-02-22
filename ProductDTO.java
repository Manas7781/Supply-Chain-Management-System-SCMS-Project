package com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.dto;

public class ProductDTO {
	
	private Long id;
	private String name;
	private Double price;
	private Long stockQuantity;
	private Long supplierId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(Long stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	
}

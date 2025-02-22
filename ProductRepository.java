package com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
List<Product> findBySupplierId(int supplierId);
}

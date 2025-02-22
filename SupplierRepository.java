package com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}

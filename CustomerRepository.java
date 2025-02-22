package com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.entity.Customer;
import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.entity.Order;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

package com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.service;

import java.util.List;

import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.dto.CustomerDTO;

public interface CustomerService {
	CustomerDTO addCustomer(CustomerDTO customerDto);

	CustomerDTO getCustomerById(Long id);

	List<CustomerDTO> getAllCustomer();

	CustomerDTO updateCustomer(Long id, CustomerDTO customerDto);

	void deleteCustomer(Long id);
}

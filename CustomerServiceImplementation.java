package com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.dto.CustomerDTO;
import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.entity.Customer;
import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.repository.CustomerRepository;

@Service
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CustomerDTO addCustomer(CustomerDTO CustomerDto) {
		Customer customer = modelMapper.map(CustomerDto, Customer.class);
		Customer savedCustomer = customerRepository.save(customer);
		return modelMapper.map(savedCustomer, CustomerDTO.class);
	}

	@Override
	public CustomerDTO getCustomerById(Long id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
		return modelMapper.map(customer, CustomerDTO.class);
	}

	@Override
	public List<CustomerDTO> getAllCustomer() {
		return customerRepository.findAll().stream().map(customer -> modelMapper.map(customer, CustomerDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public CustomerDTO updateCustomer(Long id, CustomerDTO CustomerDto) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Customer not found"));
		modelMapper.map(CustomerDto, customer);
		Customer updatedCustomer = customerRepository.save(customer);
		return modelMapper.map(updatedCustomer, CustomerDTO.class);
	}

	@Override
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}
	
}

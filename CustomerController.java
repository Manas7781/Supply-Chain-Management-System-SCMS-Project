package com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.dto.CustomerDTO;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @PostMapping
    public CustomerDTO addCustomer(@RequestBody CustomerDTO customerDto) {
        return customerService.addCustomer(customerDto);
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @PutMapping("/{id}")
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDto) {
        return customerService.updateCustomer(id, customerDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
    
}

package com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.dto.SupplierDTO;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
//	@Autowired
//	private SupplierService supplierservice;
//
//	@PostMapping
//	public SupplierDTO saveSupplier(@RequestBody SupplierDTO supplierdto) {
//		return supplierservice.saveSupplier(supplierdto);
//
//	}
	
	
	@Autowired
    private SupplierService supplierService;

    // Save Supplier
    @PostMapping
    public ResponseEntity<SupplierDTO> saveSupplier(@RequestBody SupplierDTO supplierDto) {
        SupplierDTO savedSupplier = supplierService.saveSupplier(supplierDto);
        return new ResponseEntity<>(savedSupplier, HttpStatus.CREATED);
    }

    // Get Supplier by ID
    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable Long id) {
        SupplierDTO supplier = supplierService.getSupplierById(id);
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }

    // Get All Suppliers
    @GetMapping
    public ResponseEntity<List<SupplierDTO>> getAllSuppliers() {
        List<SupplierDTO> suppliers = supplierService.getAllSupplier();
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    // Update Supplier by ID
    @PutMapping("/{id}")
    public ResponseEntity<SupplierDTO> updateSupplier(@PathVariable Long id, @RequestBody SupplierDTO supplierDto) {
        SupplierDTO updatedSupplier = supplierService.updateSupplier(id, supplierDto);
        return new ResponseEntity<>(updatedSupplier, HttpStatus.OK);
    }

    // Delete Supplier by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

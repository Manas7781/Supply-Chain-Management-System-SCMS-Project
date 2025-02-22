package com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.service;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.dto.SupplierDTO;
import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.entity.Supplier;
import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.repository.SupplierRepository;

@Service
public class SupplierServiceImplementation implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SupplierDTO saveSupplier(SupplierDTO supplierDto) {
        Supplier supplier = modelMapper.map(supplierDto, Supplier.class);
        Supplier savedSupplier = supplierRepository.save(supplier);
        return modelMapper.map(savedSupplier, SupplierDTO.class);
    }

    @Override
    public SupplierDTO getSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(()-> new RuntimeException("Supplier not found"));
        return modelMapper.map(supplier, SupplierDTO.class);
    }

    @Override
    public List<SupplierDTO> getAllSupplier() {
        return supplierRepository.findAll().stream()
                .map(supplier -> modelMapper.map(supplier, SupplierDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SupplierDTO updateSupplier(Long id, SupplierDTO supplierDto) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found"));
        modelMapper.map(supplierDto, supplier);
        Supplier updatedSupplier = supplierRepository.save(supplier);
        return modelMapper.map(updatedSupplier, SupplierDTO.class);
    }

	@Override
	public void deleteSupplier(Long id) {
		
	}

	

}

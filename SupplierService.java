package com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.service;

import java.util.List;



import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.dto.SupplierDTO;

public interface SupplierService {
	SupplierDTO saveSupplier(SupplierDTO supplierdto);

	SupplierDTO getSupplierById(Long id);

	List<SupplierDTO> getAllSupplier();

	SupplierDTO updateSupplier(Long id, SupplierDTO supplierdto);

	void deleteSupplier(Long id);

}

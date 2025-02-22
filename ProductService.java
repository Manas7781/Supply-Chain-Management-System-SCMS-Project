package com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.service;


import java.util.List;

import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.dto.ProductDTO;

public interface ProductService {
    ProductDTO addProduct(ProductDTO productDto);
    ProductDTO getProductById(Long id);
    List<ProductDTO> getAllProduct();
    List<ProductDTO> getProductBySupplierId(Long supplierId);
    ProductDTO updateProduct(Long id, ProductDTO productDto);
    void deleteProduct(Long id);
}

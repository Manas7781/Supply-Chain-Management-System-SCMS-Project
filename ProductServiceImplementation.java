package com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.dto.ProductDTO;
import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.entity.Product;
import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.entity.Supplier;
import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.repository.ProductRepository;
import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.repository.SupplierRepository;

@Service

public class ProductServiceImplementation implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ProductDTO addProduct(ProductDTO productDto) {
        Supplier supplier = supplierRepository.findById(productDto.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
        Product product = modelMapper.map(productDto, Product.class);
        product.setSupplier(supplier);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return modelMapper.map(product, ProductDTO.class);
    }

    public List<ProductDTO> getAllProduct() {
        return productRepository.findAll().stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductBySupplierId(Long supplierId) {
        return productRepository.findById(supplierId).stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        modelMapper.map(productDto, product);
        Product updatedProduct = productRepository.save(product);
        return modelMapper.map(updatedProduct, ProductDTO.class);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

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

import com.supplychainmanagementsystemappdemo.SupplyChainManagementSysDemo.dto.ProductDTO;

@RestController
@RequestMapping("/api/products")

public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductDTO addProduct(@RequestBody ProductDTO productDto) {
        return productService.addProduct(productDto);
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<ProductDTO> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/supplier/{supplierId}")
    public List<ProductDTO> getProductBySupplierId(@PathVariable Long supplierId) {
        return productService.getProductBySupplierId(supplierId);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDto) {
        return productService.updateProduct(id, productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}

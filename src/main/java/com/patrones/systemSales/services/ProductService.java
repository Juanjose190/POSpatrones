/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.patrones.systemSales.services;

/**
 *
 * @author JUAN JOSE
 */
import com.patrones.systemSales.model.Product;
import com.patrones.systemSales.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    
    public boolean saveOrUpdate(Product product) {
        try {
            productRepository.save(product); 
            return true;
        } catch (Exception e) {
            System.out.println("Error while saving/updating product: " + e.getMessage());
            return false;
        }
    }


    public boolean existsProduct(String productName) {
        return productRepository.findByName(productName).isPresent();  // Return true if product exists
    }

    /**
     * Update an existing product by its ID
     *
     * @param product The product with updated data
     * @param productId The ID of the product to update
     * @return true if updated successfully, false otherwise
     */
    public boolean update(Product product, int productId) {
        try {
            product.setIdProduct(productId);  // Set the provided ID to the product
            productRepository.save(product);  // Save the updated product
            return true;
        } catch (Exception e) {
            System.out.println("Error while updating product: " + e.getMessage());
            return false;
        }
    }

    /**
     * Delete a product by its ID
     *
     * @param productId The ID of the product to delete
     * @return true if deleted successfully, false otherwise
     */
    public boolean delete(int productId) {
        try {
            productRepository.deleteById(productId);  // Delete product by ID
            return true;
        } catch (Exception e) {
            System.out.println("Error while deleting product: " + e.getMessage());
            return false;
        }
    }

  
    
    public boolean updateStock(int productId, int newQuantity) {
        Optional<Product> productOpt = productRepository.findById(productId);  // Find the product by ID
        if (productOpt.isPresent()) {
            Product product = productOpt.get();  // Get the product object
            product.setQuantity(newQuantity);  // Set the new quantity
            productRepository.save(product);  // Save the updated product
            return true;
        }
        return false;
    }
}

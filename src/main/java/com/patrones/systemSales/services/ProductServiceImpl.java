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

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean save(Product product) {
        try {
            productRepository.save(product);
            return true;
        } catch (Exception e) {
            System.out.println("Error while saving product: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean existsProduct(String productName) {
        return productRepository.findByName(productName).isPresent();
    }

    @Override
    public boolean update(Product product, int productId) {
        try {
            product.setIdProduct(productId);
            productRepository.save(product);
            return true;
        } catch (Exception e) {
            System.out.println("Error while updating product: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int productId) {
        try {
            productRepository.deleteById(productId);
            return true;
        } catch (Exception e) {
            System.out.println("Error while deleting product: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateStock(int productId, int newQuantity) {
        Optional<Product> productOpt = productRepository.findById(productId);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            product.setQuantity(newQuantity);
            productRepository.save(product);
            return true;
        }
        return false;
    }
}

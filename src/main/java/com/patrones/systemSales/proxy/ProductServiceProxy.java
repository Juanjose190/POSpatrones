/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.patrones.systemSales.proxy;

/**
 *
 * @author JUAN JOSE
 */


import com.patrones.systemSales.model.Product;
import com.patrones.systemSales.services.ProductService;

import java.util.List;

public class ProductServiceProxy implements ProductService {

    private final ProductService productService;

    public ProductServiceProxy(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public boolean save(Product product) {
     
        System.out.println("Saving product: " + product.getName());
        return productService.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productService.findAll();
    }

    @Override
    public boolean existsProduct(String productName) {
        return productService.existsProduct(productName);
    }

    @Override
    public boolean update(Product product, int productId) {
     
        System.out.println("Updating product with ID: " + productId);
        return productService.update(product, productId);
    }

    @Override
    public boolean delete(int productId) {
      
        System.out.println("Deleting product with ID: " + productId);
        return productService.delete(productId);
    }

    @Override
    public boolean updateStock(int productId, int newQuantity) {
      
        System.out.println("Updating stock for product with ID: " + productId);
        return productService.updateStock(productId, newQuantity);
    }
}


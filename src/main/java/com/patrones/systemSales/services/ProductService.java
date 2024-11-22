package com.patrones.systemSales.services;

import com.patrones.systemSales.model.Product;
import java.util.List;

public interface ProductService {
    boolean save(Product product);
    List<Product> findAll();
    boolean existsProduct(String productName);
    boolean update(Product product, int productId);
    boolean delete(int productId);
    boolean updateStock(int productId, int newQuantity);
}

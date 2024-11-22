package com.patrones.systemSales;

import com.patrones.systemSales.model.Product;
import com.patrones.systemSales.services.ProductService;
import com.patrones.systemSales.services.ProductServiceImpl;
import com.patrones.systemSales.proxy.ProductServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class Ctrl_Product {

    private final ProductService productService;

    @Autowired
    public Ctrl_Product(ProductServiceImpl productServiceImpl) {
        this.productService = new ProductServiceProxy(productServiceImpl);
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        try {
            productService.save(product);
            return ResponseEntity.status(201).body(product);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId) {
        Product product = productService.findAll().stream()
                .filter(p -> p.getIdProduct() == productId)
                .findFirst()
                .orElse(null);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.status(404).build();
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable int productId) {
        try {
            productService.update(product, productId);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> delete(@PathVariable int productId) {
        try {
            productService.delete(productId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PatchMapping("/{productId}/updateStock")
    public ResponseEntity<Boolean> updateStock(@PathVariable int productId, @RequestParam int newQuantity) {
        try {
            boolean result = productService.updateStock(productId, newQuantity);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}

package com.patrones.systemSales;

import com.patrones.systemSales.model.Category;
import com.patrones.systemSales.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class Ctrl_Category {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        try {
            System.out.println("Received category: " + category);
            Category savedCategory = categoryService.saveCategory(category);
            System.out.println("Categoría guardada: " + savedCategory);
            return ResponseEntity.status(201).body(savedCategory);
        } catch (Exception e) {
            System.err.println("Error al guardar la categoría: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
        Category category = categoryService.getCategoryById(id);
        if (category == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(category);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category) {
        Category updatedCategory = categoryService.updateCategory(id, category);
        if (updatedCategory == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.patrones.systemSales;

/**
 *
 * @author JUAN JOSE
 */
import com.patrones.systemSales.model.Customer;
import com.patrones.systemSales.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/customers")
public class Ctrl_Customer {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody Customer customer) {
        Customer newCustomer = customerService.save(customer);
        return ResponseEntity.ok(newCustomer);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> list() {
        List<Customer> customers = customerService.findAll();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/exists/{idCard}")
    public ResponseEntity<Boolean> exists(@PathVariable String idCard) {
        boolean exists = customerService.existsByIdCard(idCard);
        return ResponseEntity.ok(exists);
    }

    @PutMapping("/{idCustomer}")
    public ResponseEntity<Customer> update(@PathVariable int idCustomer, @RequestBody Customer customer) {
        return customerService.update(idCustomer, customer)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

   @DeleteMapping("/{idCustomer}")
public ResponseEntity<Void> delete(@PathVariable int idCustomer) {
    return customerService.delete(idCustomer) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
}

}

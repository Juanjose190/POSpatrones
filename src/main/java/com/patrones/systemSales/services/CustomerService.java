/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.patrones.systemSales.services;

/**
 *
 * @author JUAN JOSE
 */
import com.patrones.systemSales.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.patrones.systemSales.repository.ClientRepository;

@Service
public class CustomerService {

    private final ClientRepository customerRepository;

    @Autowired
    public CustomerService(ClientRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public boolean existsByIdCard(String idCard) {
        return customerRepository.existsByIdCard(idCard);
    }

    public Optional<Customer> update(int idCustomer, Customer customer) {
        if (customerRepository.existsById(idCustomer)) {
            customer.setIdCustomer(idCustomer);
            return Optional.of(customerRepository.save(customer));
        }
        return Optional.empty();
    }

    public boolean delete(int idCustomer) {
        if (customerRepository.existsById(idCustomer)) {
            customerRepository.deleteById(idCustomer);
            return true;
        }
        return false;
    }
}

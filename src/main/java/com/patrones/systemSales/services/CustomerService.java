package com.patrones.systemSales.services;

import com.patrones.systemSales.model.Customer;
import com.patrones.systemSales.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private static CustomerService instance;

    @Autowired
    private ClientRepository customerRepository;

    private CustomerService() {
       
    }

    public static synchronized CustomerService getInstance() {
        if (instance == null) {
            instance = new CustomerService();
        }
        return instance;
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

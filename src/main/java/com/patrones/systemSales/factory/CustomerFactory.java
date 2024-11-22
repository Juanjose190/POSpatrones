/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.patrones.systemSales.factory;

import com.patrones.systemSales.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerFactory {

    public Customer createCustomer() {
        return new Customer();
    }
}

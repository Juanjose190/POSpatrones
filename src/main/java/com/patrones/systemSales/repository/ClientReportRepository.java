/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.patrones.systemSales.repository;

/**
 *
 * @author JUAN JOSE
 */


import com.patrones.systemSales.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientReportRepository {

    @Query("SELECT c FROM Client c")
    List<Customer> getClients();
}


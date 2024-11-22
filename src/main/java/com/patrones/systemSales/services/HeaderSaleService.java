/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.patrones.systemSales.services;

/**
 *
 * @author JUAN JOSE
 */
import com.patrones.systemSales.model.HeaderSale;
import com.patrones.systemSales.repository.HeaderSaleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeaderSaleService {
    @Autowired
    private HeaderSaleRepository headerSaleRepository;

    public boolean registerSale(HeaderSale headerSale) {
        try {
            headerSaleRepository.save(headerSale);
            return true;
        } catch (Exception e) {
            System.out.println("Error saving Header Sale: " + e);
            return false;
        }
    }

    public List<HeaderSale> listSales() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
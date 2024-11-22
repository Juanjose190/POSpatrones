/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.patrones.systemSales;

/**
 *
 * @author JUAN JOSE
 */
import com.patrones.systemSales.model.HeaderSale;
import com.patrones.systemSales.services.HeaderSaleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales")
public class HeaderSaleController {

    @Autowired
    private HeaderSaleService headerSaleService;

    @PostMapping("/register")
    public boolean registerSale(@RequestBody HeaderSale headerSale) {
        return headerSaleService.registerSale(headerSale);
    }
    
       @GetMapping("/list")
    public List<HeaderSale> listSales() {
        return headerSaleService.listSales();
    }
}

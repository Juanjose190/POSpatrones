package com.patrones.systemSales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.patrones.systemSales")
public class SystemSalesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemSalesApplication.class, args);
    }
}

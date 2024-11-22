package com.patrones.systemSales.model;

import com.itextpdf.text.pdf.PdfPCell;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;

    private String name;
    private String description;
    private double price;
    private int quantity;
    private double taxPercentage;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public double getTotalPrice() {
        return price * quantity * (1 + (taxPercentage / 100));
    }

    @Override
    public String toString() {
        return "Product{"
                + "idProduct=" + idProduct
                + ", name='" + name + '\''
                + ", description='" + description + '\''
                + ", price=" + price
                + ", quantity=" + quantity
                + ", taxPercentage=" + taxPercentage
                + '}';
    }


}

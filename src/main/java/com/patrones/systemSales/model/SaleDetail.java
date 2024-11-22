/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.patrones.systemSales.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author JUAN JOSE
 */
@Entity
@Table(name = "detalle_venta")
public class SaleDetail {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSaleDetail;
    private int idSaleHeader;
    private int idProduct;
    private String productName;
    private int quantity;
    private double unitPrice;
    private double subTotal;
    private double discount;
    private double tax;
    private double totalToPay;
    private int status;

    public SaleDetail() {
        this.idSaleDetail = 0;
        this.idSaleHeader = 0;
        this.idProduct = 0;
        this.productName = "";
        this.quantity = 0;
        this.unitPrice = 0.0;
        this.subTotal = 0.0;
        this.discount = 0.0;
        this.tax = 0.0;
        this.totalToPay = 0.0;
        this.status = 0;
    }


    public SaleDetail(int idSaleDetail, int idSaleHeader, int idProduct, String productName, int quantity,
            double unitPrice, double subTotal, double discount, double tax, double totalToPay, int status) {
        this.idSaleDetail = idSaleDetail;
        this.idSaleHeader = idSaleHeader;
        this.idProduct = idProduct;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subTotal = subTotal;
        this.discount = discount;
        this.tax = tax;
        this.totalToPay = totalToPay;
        this.status = status;
    }


    public int getIdSaleDetail() {
        return idSaleDetail;
    }

    public void setIdSaleDetail(int idSaleDetail) {
        this.idSaleDetail = idSaleDetail;
    }

    public int getIdSaleHeader() {
        return idSaleHeader;
    }

    public void setIdSaleHeader(int idSaleHeader) {
        this.idSaleHeader = idSaleHeader;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotalToPay() {
        return totalToPay;
    }

    public void setTotalToPay(double totalToPay) {
        this.totalToPay = totalToPay;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

   
    @Override
    public String toString() {
        return "SaleDetail{"
                + "idSaleDetail=" + idSaleDetail
                + ", idSaleHeader=" + idSaleHeader
                + ", idProduct=" + idProduct
                + ", productName='" + productName + '\''
                + ", quantity=" + quantity
                + ", unitPrice=" + unitPrice
                + ", subTotal=" + subTotal
                + ", discount=" + discount
                + ", tax=" + tax
                + ", totalToPay=" + totalToPay
                + ", status=" + status
                + '}';
    }
}

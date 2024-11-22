/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.patrones.systemSales.model;

/**
 *
 * @author JUAN JOSE
 */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_cabecera_venta")
public class HeaderSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCabeceraVenta")
    private int idHeaderSale;

    @Column(name = "idCliente")
    private int idClient;

    @Column(name = "valorPagar")
    private double amountToPay;

    @Column(name = "fechaVenta")
    private String saleDate;

    @Column(name = "estado")
    private int status;

    public HeaderSale() {
        this.idHeaderSale = 0;
        this.idClient = 0;
        this.amountToPay = 0.0;
        this.saleDate = "";
        this.status = 0;
    }

    public HeaderSale(int idHeaderSale, int idClient, double amountToPay, String saleDate, int status) {
        this.idHeaderSale = idHeaderSale;
        this.idClient = idClient;
        this.amountToPay = amountToPay;
        this.saleDate = saleDate;
        this.status = status;
    }

    public int getIdHeaderSale() {
        return idHeaderSale;
    }

    public void setIdHeaderSale(int idHeaderSale) {
        this.idHeaderSale = idHeaderSale;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public double getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(double amountToPay) {
        this.amountToPay = amountToPay;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HeaderSale{"
                + "idHeaderSale=" + idHeaderSale
                + ", idClient=" + idClient
                + ", amountToPay=" + amountToPay
                + ", saleDate='" + saleDate + '\''
                + ", status=" + status
                + '}';
    }
}

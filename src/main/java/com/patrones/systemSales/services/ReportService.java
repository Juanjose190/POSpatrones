/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.patrones.systemSales.services;

/**
 *
 * @author JUAN JOSE
 */



import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.patrones.systemSales.repository.ClientRepository;
import com.patrones.systemSales.repository.ProductRepository;
import com.patrones.systemSales.repository.CategoryRepository;
import com.patrones.systemSales.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SaleRepository saleRepository;

    private static final String HEADER_IMAGE_PATH = "src/img/header1.jpg";

    public void generateClientReport() throws DocumentException, FileNotFoundException, IOException {
        Document document = new Document();
        String path = System.getProperty("user.home");
        PdfWriter.getInstance(document, new FileOutputStream(path + "/Desktop/Client_Report.pdf"));

        Image header = Image.getInstance(HEADER_IMAGE_PATH);
        header.scaleToFit(650, 1000);
        header.setAlignment(Chunk.ALIGN_CENTER);

        Paragraph paragraph = new Paragraph("Client Report \n\n", FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        document.open();
        document.add(header);
        document.add(paragraph);

        PdfPTable table = new PdfPTable(5);
        table.addCell("Code");
        table.addCell("Name");
        table.addCell("ID");
        table.addCell("Phone");
        table.addCell("Address");

        clientRepository.findAll().forEach(client -> {
            table.addCell(String.valueOf(client.getIdCustomer()));
            table.addCell(client.getFirstName());
            table.addCell(client.getPhone());
            table.addCell(client.getAddress());
        });

        document.add(table);
        document.close();
    }

    public void generateProductReport() throws DocumentException, FileNotFoundException, IOException {
        Document document = new Document();
        String path = System.getProperty("user.home");
        PdfWriter.getInstance(document, new FileOutputStream(path + "/Desktop/Product_Report.pdf"));

        Image header = Image.getInstance(HEADER_IMAGE_PATH);
        header.scaleToFit(650, 1000);
        header.setAlignment(Chunk.ALIGN_CENTER);

        Paragraph paragraph = new Paragraph("Product Report \n\n", FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        document.open();
        document.add(header);
        document.add(paragraph);

        PdfPTable table = new PdfPTable(7);
        table.addCell("Code");
        table.addCell("Name");
        table.addCell("Quantity");
        table.addCell("Price");
        table.addCell("Description");
        table.addCell("VAT %");
        table.addCell("Category");

        productRepository.findAll().forEach(product -> {
            table.addCell(String.valueOf(product.getIdProduct()));
            table.addCell(product.getName());
            table.addCell(String.valueOf(product.getQuantity()));
            table.addCell(String.valueOf(product.getPrice()));
            table.addCell(product.getDescription());
            table.addCell(String.valueOf(product.getTaxPercentage()));
            table.addCell(product.getDescription()); 
        });

        document.add(table);
        document.close();
    }

    public void generateCategoryReport() throws DocumentException, FileNotFoundException, IOException {
        Document document = new Document();
        String path = System.getProperty("user.home");
        PdfWriter.getInstance(document, new FileOutputStream(path + "/Desktop/Category_Report.pdf"));

        Image header = Image.getInstance(HEADER_IMAGE_PATH);
        header.scaleToFit(650, 1000);
        header.setAlignment(Chunk.ALIGN_CENTER);

        Paragraph paragraph = new Paragraph("Category Report \n\n", FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        document.open();
        document.add(header);
        document.add(paragraph);

        PdfPTable table = new PdfPTable(3);
        table.addCell("Code");
        table.addCell("Description");
        table.addCell("State");

        categoryRepository.findAll().forEach(category -> {
            table.addCell(String.valueOf(category.getIdCategory()));
            table.addCell(category.getDescription());
            table.addCell(String.valueOf(category.getStatus())); 
        });

        document.add(table);
        document.close();
    }

    public void generateSaleReport() throws DocumentException, FileNotFoundException, IOException {
        Document document = new Document();
        String path = System.getProperty("user.home");
        PdfWriter.getInstance(document, new FileOutputStream(path + "/Desktop/Sale_Report.pdf"));

        Image header = Image.getInstance(HEADER_IMAGE_PATH);
        header.scaleToFit(650, 1000);
        header.setAlignment(Chunk.ALIGN_CENTER);

        Paragraph paragraph = new Paragraph("Sale Report \n\n", FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        document.open();
        document.add(header);
        document.add(paragraph);

        PdfPTable table = new PdfPTable(5);
        table.addCell("Code");
        table.addCell("Client");
        table.addCell("Total");
        table.addCell("Sale Date");
        table.addCell("Status");

        saleRepository.findAll().forEach(sale -> {
            table.addCell(String.valueOf(sale.getId()));
            table.addCell(sale.getClientName());
            table.addCell(String.valueOf(sale.getTotalAmount()));
            table.addCell(sale.getSaleDate().toString()); 
            table.addCell(sale.getStatus());
        });

        document.add(table);
        document.close();
    }
}

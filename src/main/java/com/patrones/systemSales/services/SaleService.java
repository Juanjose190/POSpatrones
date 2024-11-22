package com.patrones.systemSales.services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.patrones.systemSales.model.Sale;
import com.patrones.systemSales.model.Product;
import com.patrones.systemSales.repository.SaleRepository;
import com.patrones.systemSales.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductRepository productRepository;

    private String currentDate;
    private String clientName;
    private double totalAmount;

    private static final String HEADER_IMAGE_PATH = "src/img/sales.png";

    public void setSaleData(Long saleId) {
        Sale sale = saleRepository.findById(saleId).orElse(null);
        if (sale != null) {
            this.clientName = sale.getClientName();
            this.totalAmount = sale.getTotalAmount();
        }
    }

    public void generateSaleReport(Long saleId) {
        try {
            setSaleData(saleId);

            Date date = new Date();
            currentDate = new SimpleDateFormat("yyyy_MM_dd").format(date);

            String fileName = "Sale_" + clientName + "_" + currentDate + ".pdf";
            FileOutputStream fileOutputStream = new FileOutputStream(new File("src/pdf/" + fileName));

            Document document = new Document();
            PdfWriter.getInstance(document, fileOutputStream);
            document.open();

            Image img = Image.getInstance(HEADER_IMAGE_PATH);
            img.scaleToFit(650, 1000);
            img.setAlignment(Element.ALIGN_CENTER);

            Paragraph header = new Paragraph("Invoice: 001\nDate: " + currentDate + "\n\n", new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE));
            header.setAlignment(Element.ALIGN_CENTER);

            PdfPTable tableHeader = new PdfPTable(4);
            tableHeader.setWidthPercentage(100);
            tableHeader.getDefaultCell().setBorder(0);
            tableHeader.addCell(img);
            tableHeader.addCell("");
            tableHeader.addCell("RUC: 0987654321001\nNAME: Ghost Corporation\nPHONE: 0987654321\nADDRESS: Tamarindo City");
            tableHeader.addCell(header);
            document.add(tableHeader);

            Paragraph saleDetails = new Paragraph("Sale Details:\n\n");
            document.add(saleDetails);

            PdfPTable saleTable = new PdfPTable(2);
            saleTable.setWidthPercentage(100);
            saleTable.getDefaultCell().setBorder(0);
            saleTable.addCell("Client:");
            saleTable.addCell(clientName);
            saleTable.addCell("Total to Pay:");
            saleTable.addCell(String.valueOf(totalAmount));
            document.add(saleTable);

            List<Product> products = productRepository.findAll();
            Paragraph productsHeading = new Paragraph("\nProducts in the Sale:\n\n");
            document.add(productsHeading);

            PdfPTable productTable = new PdfPTable(4);
            productTable.setWidthPercentage(100);
            productTable.getDefaultCell().setBorder(0);
            productTable.addCell("Quantity");
            productTable.addCell("Description");
            productTable.addCell("Unit Price");
            productTable.addCell("Total Price");

            for (Product product : products) {
                productTable.addCell(String.valueOf(product.getQuantity()));
                productTable.addCell(product.getName());
                productTable.addCell(String.valueOf(product.getPrice()));
                productTable.addCell(String.valueOf(product.getTotalPrice()));
            }

            document.add(productTable);

            Paragraph signature = new Paragraph("\nSignature:\n_______________________");
            signature.setAlignment(Element.ALIGN_CENTER);
            document.add(signature);

            Paragraph thankYouMessage = new Paragraph("\nThank you for your purchase!");
            thankYouMessage.setAlignment(Element.ALIGN_CENTER);
            document.add(thankYouMessage);

            document.close();
            fileOutputStream.close();

            File pdfFile = new File("src/pdf/" + fileName);
            Desktop.getDesktop().open(pdfFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

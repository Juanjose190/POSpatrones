package com.patrones.systemSales;




import com.patrones.systemSales.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/reports/clients")
    public String generateClientReport() {
        try {
            reportService.generateClientReport();
            return "Client report generated successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error generating client report.";
        }
    }

    @GetMapping("/reports/products")
    public String generateProductReport() {
        try {
            reportService.generateProductReport();
            return "Product report generated successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error generating product report.";
        }
    }

    @GetMapping("/reports/categories")
    public String generateCategoryReport() {
        try {
            reportService.generateCategoryReport();
            return "Category report generated successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error generating category report.";
        }
    }

    @GetMapping("/reports/sales")
    public String generateSaleReport() {
        try {
            reportService.generateSaleReport();
            return "Sale report generated successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error generating sale report.";
        }
    }
}




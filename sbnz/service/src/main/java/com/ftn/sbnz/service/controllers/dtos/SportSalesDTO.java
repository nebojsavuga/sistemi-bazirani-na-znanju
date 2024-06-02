package com.ftn.sbnz.service.controllers.dtos;

import java.util.List;

public class SportSalesDTO {
    public List<SportSaleDTO> sales;
    public int totalSales;
    public List<SportSaleDTO> getSales() {
        return sales;
    }
    public void setSales(List<SportSaleDTO> sales) {
        this.sales = sales;
    }
    public int getTotalSales() {
        return totalSales;
    }
    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }
    public SportSalesDTO(List<SportSaleDTO> sales, int totalSales) {
        this.sales = sales;
        this.totalSales = totalSales;
    }
}

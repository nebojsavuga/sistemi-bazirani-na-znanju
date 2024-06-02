package com.ftn.sbnz.service.controllers.dtos;

public class SportSaleDTO {
    public String sport;
    public int totalSales;

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public int getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }

    public SportSaleDTO(String sport, int totalSales) {
        this.sport = sport;
        this.totalSales = totalSales;
    }

    public void addSale() {
        this.totalSales += 1;
    }
}

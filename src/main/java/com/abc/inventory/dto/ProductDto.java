package com.abc.inventory.dto;

import java.util.Date;

public class ProductDto {
    private String id;
    private String name;
    private double price;
    private Date expirdDate;
    private int taxRate;
    private int discountRate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getExpirdDate() {
        return expirdDate;
    }

    public void setExpirdDate(Date expirdDate) {
        this.expirdDate = expirdDate;
    }

    public int getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(int taxRate) {
        this.taxRate = taxRate;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }
}

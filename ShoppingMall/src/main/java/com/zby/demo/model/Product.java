package com.zby.demo.model;

public class Product {
    private Long id;
    private String cName;
    private Double dPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Double getfPrice() {
        return dPrice;
    }

    public void setfPrice(Double fPrice) {
        this.dPrice = fPrice;
    }
}

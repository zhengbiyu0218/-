package com.zby.demo.model;

public class Product {
    private Long id;
    private String cName;
    private Double dPrice;
    private Double dQuantity;

    public Double getdPrice() {
        return dPrice;
    }

    public void setdPrice(Double dPrice) {
        this.dPrice = dPrice;
    }

    public Double getdQuantity() {
        return dQuantity;
    }

    public void setdQuantity(Double dQuantity) {
        this.dQuantity = dQuantity;
    }

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

}

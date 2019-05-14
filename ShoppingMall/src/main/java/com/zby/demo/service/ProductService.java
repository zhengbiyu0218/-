package com.zby.demo.service;

import com.zby.demo.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAll();
    public boolean updateProduct(Product product);
    public boolean delProduct(int id);
}

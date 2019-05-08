package com.zby.demo.dao;

import com.zby.demo.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDao {
    public List<Product> getAll();
    public int addProduct(Product product);
    public int updateProduct(Product product);
    public int delProduct(Long id);
}

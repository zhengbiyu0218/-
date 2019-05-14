package com.zby.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zby.demo.model.Product;

@Mapper
public interface ProductDao {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    
    List<Product> getProductList();
}
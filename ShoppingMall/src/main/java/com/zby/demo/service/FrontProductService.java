package com.zby.demo.service;

import com.zby.demo.model.Product;

import java.util.List;

public interface FrontProductService {

	List<Product> getProductList();
	
	Product getProductById(Integer id);
}

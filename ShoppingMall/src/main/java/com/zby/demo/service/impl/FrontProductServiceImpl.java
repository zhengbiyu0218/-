package com.zby.demo.service.impl;


import com.zby.demo.dao.ProductDao;
import com.zby.demo.model.Product;
import com.zby.demo.service.FrontProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FrontProductServiceImpl implements FrontProductService {
	
    @Resource
    ProductDao productDao;

	@Override
	public List<Product> getProductList() {
		
		return productDao.getProductList();
	}

	@Override
	public Product getProductById(Integer id) {
		return productDao.selectByPrimaryKey(id);
	}
    
   
}

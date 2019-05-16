package com.zby.demo.service;

import com.zby.demo.model.Product;
import com.zby.demo.model.vo.SCartVO;

import java.util.List;

public interface FrontProductService {

	List<Product> getProductList();
	
	Product getProductById(Integer id);
	
	List<SCartVO> getShoppingCartList(Integer userId);
	
	String changeCart(String userId, String productId, String count, String way);
	
	String getShopCartSum(String userId);
	
	String deleteCartList(String userId, String productId);
	
}

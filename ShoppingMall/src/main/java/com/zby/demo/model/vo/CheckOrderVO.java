package com.zby.demo.model.vo;

import java.io.Serializable;
import java.util.List;

public class CheckOrderVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<SCartVO> cartList;
	
	private String sum;

	public List<SCartVO> getCartList() {
		return cartList;
	}

	public void setCartList(List<SCartVO> cartList) {
		this.cartList = cartList;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}
	
}
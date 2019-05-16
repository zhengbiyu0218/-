package com.zby.demo.service.impl;


import com.zby.demo.dao.ProductDao;
import com.zby.demo.dao.ShoppingCartInfoDao;
import com.zby.demo.model.Product;
import com.zby.demo.model.ShoppingCartInfo;
import com.zby.demo.model.vo.SCartVO;
import com.zby.demo.service.FrontProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class FrontProductServiceImpl implements FrontProductService {
	
    @Resource
    ProductDao productDao;
    
    @Resource
    ShoppingCartInfoDao shoppingCartInfoDao;

	@Override
	public List<Product> getProductList() {
		
		return productDao.getProductList();
	}

	@Override
	public Product getProductById(Integer id) {
		return productDao.selectByPrimaryKey(id);
	}

	@Override
	public List<SCartVO> getShoppingCartList(Integer userId) {
		List<ShoppingCartInfo> list = shoppingCartInfoDao.selectCartByUserId(userId);
		List<SCartVO> resultList = new ArrayList<>();
		SCartVO shop;
		for (ShoppingCartInfo s : list) {
			int pId = s.getProductId();
			shop = new SCartVO();
			shop.setId(s.getId());
			shop.setUserId(s.getUserId());
			shop.setProductId(s.getProductId());
			shop.setBuyCount(s.getBuyCount());
			shop.setIsChecked(false);
			Product pInfo = productDao.selectByPrimaryKey(pId);
			if (pInfo != null) {
				shop.setProductName(pInfo.getProductName());
				shop.setProductImg(pInfo.getProductImg());
				shop.setProductPrice(pInfo.getPrice());
				shop.setProductSize(pInfo.getProductSize());
				resultList.add(shop);
			}
		}
		return resultList;
	}

	@Override
	public String changeCart(String userId, String productId, String count, String way) {
		System.out.println("userId="+userId+",productId="+productId+",count="+count+",way="+way);
		
		if (userId == null || productId == null || count == null) {
			return "入参为空";
		}
		int pId = Integer.valueOf(productId);
		int uId = Integer.valueOf(userId);
		int c = Integer.valueOf(count);
		// 查找之前是否添加过该商品在购物车
		ShoppingCartInfo pCart = shoppingCartInfoDao.selectCartByProductId(uId, pId);
		// 如果没有添加过该商品 
		if (pCart == null) {
			System.out.println("-->该商品未在购物车内，新增");
			ShoppingCartInfo newInfo = new ShoppingCartInfo();
			newInfo.setProductId(pId);
			newInfo.setUserId(uId);
			newInfo.setBuyCount(c);
			newInfo.setUpdateTime(new Date());
			newInfo.setInputTime(new Date());
			
			Integer result = shoppingCartInfoDao.insert(newInfo);
			if (result == 1) {
				return "添加成功";
			} else {
				return "添加失败";
			}
		} else {
			System.out.println("-->该商品在购物车内");
			
			// 重置
			if (way.equals("1")) {
				System.out.println("-->该商品在购物车内-重置购买个数:"+c);
				pCart.setBuyCount(c);
			//新增
			} else if (way.equals("2")) {
				int oldCount = pCart.getBuyCount();
				System.out.println("-->该商品在购物车内-增加个数:老个数"+oldCount+"+新个数"+c);
				pCart.setBuyCount(oldCount+c);
				pCart.setUpdateTime(new Date());
			}

			Integer result = shoppingCartInfoDao.updateByPrimaryKey(pCart);
			if (result == 1) {
				return "更新购物车成功";
			} else {
				return "添加失败";
			}
		}

	}

	@Override
	public String getShopCartSum(String userId) {
		if (userId == null) {
			return "用户id不能为空";
		}
		Integer result = shoppingCartInfoDao.getCartSumByUserId(Integer.valueOf(userId));

		return result.toString();

	}

	@Override
	public String deleteCartList(String userId, String productId) {
		System.out.println("userId="+userId+",productId="+productId);
		if (userId == null || productId == null) {
			return "数据不能为空";
		}
		int uId = Integer.valueOf(userId);
		int pId;
		int success = 0;
		int faild = 0;
		List<String> pList =  Arrays.asList(productId.split(","));
		for (String s : pList) {
			pId = Integer.valueOf(s);
			ShoppingCartInfo sCart = shoppingCartInfoDao.selectCartByProductId(uId, pId);
			if (sCart != null && sCart.getId() != null) {
				System.out.println("当前删除购物车产品编号:"+sCart.getId());
				int result = shoppingCartInfoDao.deleteByPrimaryKey(sCart.getId());
				if (result == 1) {
					success++;
				} else {
					faild++;
				}
			} else {
				faild++;
			}
		}
		return "共"+pList.size()+"个产品，删除成功"+success+"个 失败"+faild+"个";
	}

}

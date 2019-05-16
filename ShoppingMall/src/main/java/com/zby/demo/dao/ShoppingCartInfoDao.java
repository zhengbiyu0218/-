package com.zby.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zby.demo.model.ShoppingCartInfo;

@Mapper
public interface ShoppingCartInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ShoppingCartInfo record);

    int insertSelective(ShoppingCartInfo record);

    ShoppingCartInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShoppingCartInfo record);

    int updateByPrimaryKey(ShoppingCartInfo record);
    
    List<ShoppingCartInfo> selectCartByUserId(Integer userId);
    
    int getCartSumByUserId(Integer userId);
    
    ShoppingCartInfo selectCartByProductId(Integer userId, Integer productId);

}
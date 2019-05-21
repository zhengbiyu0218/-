package com.zby.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.zby.demo.model.AddressInfo;

@Mapper
public interface AddressInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AddressInfo record);

    int insertSelective(AddressInfo record);

    AddressInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AddressInfo record);

    int updateByPrimaryKey(AddressInfo record);
    
    AddressInfo selectByUserIdDefalt(Integer userId);
}
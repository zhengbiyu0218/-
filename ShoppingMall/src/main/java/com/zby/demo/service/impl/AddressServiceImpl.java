package com.zby.demo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zby.demo.dao.AddressInfoDao;
import com.zby.demo.model.AddressInfo;
import com.zby.demo.service.AddressService;
@Service
public class AddressServiceImpl implements AddressService {

	@Resource
	AddressInfoDao addressInfoDao;

	@Override
	public AddressInfo getUserDefaultAddress(String userId) {
		if (userId == null) {
			return null;
		} else {
			return addressInfoDao.selectByUserIdDefalt(Integer.valueOf(userId));
		}
	}
	
}

package com.zby.demo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zby.demo.model.AddressInfo;
import com.zby.demo.service.AddressService;
import com.zby.demo.utils.ResultMessage;

@RequestMapping("/address")
@Controller
public class FrontAddressController {
	
	@Resource
	AddressService addressService;

    @RequestMapping(value = "/getUserDefaltAddress", method = RequestMethod.GET)
    @ResponseBody
    public String getUserDefaltAddress (String userId, HttpServletRequest request) {
        AddressInfo info = addressService.getUserDefaultAddress(userId);
        return ResultMessage.data(info);
    }
}

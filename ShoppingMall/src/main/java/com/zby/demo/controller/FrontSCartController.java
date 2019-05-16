package com.zby.demo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zby.demo.model.vo.SCartVO;
import com.zby.demo.service.FrontProductService;
import com.zby.demo.utils.ResultMessage;

@RequestMapping("/shopping-cart")
@Controller
public class FrontSCartController {

    @Resource
    private FrontProductService frontProductService;

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ResponseBody
    public String getBuyList (String userId, HttpServletRequest request) {
        List<SCartVO> list = frontProductService.getShoppingCartList(Integer.valueOf(userId));
        return ResultMessage.data(list);
    }
    
    @RequestMapping(value = "/changeCart", method = RequestMethod.POST)
    @ResponseBody
    public String changeCart (String userId, String productId, String count, String way, HttpServletRequest request) {
        String result = frontProductService.changeCart(userId, productId, count, way);
        return ResultMessage.data(result);
    }
    
    
    @RequestMapping(value = "/getShopCartSum", method = RequestMethod.GET)
    @ResponseBody
    public String getShopCartSum (String userId, HttpServletRequest request) {
        String result = frontProductService.getShopCartSum(userId);
        return ResultMessage.data(result);
    }
    
    @RequestMapping(value = "/deleteCartList", method = RequestMethod.POST)
    @ResponseBody
    public String deleteCartList (String userId, String productId, HttpServletRequest request) {
        String result = frontProductService.deleteCartList(userId, productId);
        return ResultMessage.data(result);
    }
}
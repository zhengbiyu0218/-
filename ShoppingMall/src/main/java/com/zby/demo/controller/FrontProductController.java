package com.zby.demo.controller;

import com.zby.demo.model.Product;
import com.zby.demo.service.FrontProductService;
import com.zby.demo.utils.ResultMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/product")
@Controller
public class FrontProductController {

    @Resource
    private FrontProductService frontProductService;

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ResponseBody
    public String getAllProduct (HttpServletRequest request) {
        List<Product> list = frontProductService.getProductList();
        
        return ResultMessage.data(list);
    }


    @RequestMapping(value = "/getProductById", method = RequestMethod.POST)
    @ResponseBody
    public String getProductById (String id, HttpServletRequest request) {
    	System.out.println(id);
        Product p = frontProductService.getProductById(Integer.valueOf(id));
        
        return ResultMessage.data(p);
    }
}

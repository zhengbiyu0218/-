package com.zby.demo.controller;

import com.zby.demo.model.Product;
import com.zby.demo.service.ProductService;
import com.zby.demo.utils.ResultMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/product")
@Controller
public class ProductController {

    @Resource
    private ProductService productService;

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ResponseBody
    public String getAllProduct (HttpServletRequest request) {
        List list = productService.getAll();
        return ResultMessage.data(list);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateProduct (@RequestBody  Product product, HttpServletRequest request) {
        boolean success = productService.updateProduct(product);
        if (success) {
            return ResultMessage.success("操作成功");
        } else {
            return ResultMessage.error("操作失败");
        }
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public String delProduct (String id, HttpServletRequest request) {
        boolean success = productService.delProduct(Integer.valueOf(id));
        if (success) {
            return ResultMessage.success("删除商品成功");
        } else {
            return ResultMessage.error("删除商品失败");
        }
    }
}

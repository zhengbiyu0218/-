package com.zby.demo.controller;

import com.zby.demo.model.User;
import com.zby.demo.service.UserService;
import com.zby.demo.utils.ResultMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login (String name, String pass, HttpServletRequest request) {
        User user = userService.checkName(name);
        if (user == null) {
            return ResultMessage.error("用户不存在，请重新输入");
        } else {
            user = userService.checkNameAndPass(name, pass);
            if (user != null) {
                return ResultMessage.success("登录成功");
            } else {
                return ResultMessage.error("账号密码输入错误，请重新输入");
            }
        }
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String register (String name, String pass, HttpServletRequest request) {
        User user = userService.checkName(name);
        if (user == null) {
            boolean result = userService.addUser(name, pass);
            if (result) {
                return ResultMessage.success("注册成功");
            } else {
                return ResultMessage.error("注册失败");
            }
        } else {
            return ResultMessage.error("账号已存在，请重新输入");
        }
    }
}

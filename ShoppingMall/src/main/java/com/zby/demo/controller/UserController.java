package com.zby.demo.controller;

import com.zby.demo.model.User;
import com.zby.demo.service.UserService;
import com.zby.demo.utils.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login (String name, String pass, HttpServletRequest request) {
        User user = null;
        if (request.getParameter("token") != null) {
            user = (User) redisTemplate.opsForValue().get(request.getParameter("token"));
        }
        user = userService.checkName(name);
        if (user == null) {
            return ResultMessage.error("用户不存在，请重新输入");
        } else {
            user = userService.checkNameAndPass(name, pass);
            if (user != null) {
                String uid = UUID.randomUUID().toString().replaceAll("-","");
                Map<String , String> map = new HashMap<>();
                map.put("name", user.getcName());
                map.put("token", uid);
                redisTemplate.opsForValue().set(uid, user, 30, TimeUnit.SECONDS);
                return ResultMessage.success("登录成功", map);
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

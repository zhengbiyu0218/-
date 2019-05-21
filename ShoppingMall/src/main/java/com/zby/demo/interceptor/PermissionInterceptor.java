package com.zby.demo.interceptor;

import com.google.gson.Gson;
import com.zby.demo.model.User;
import com.zby.demo.service.UserService;
import com.zby.demo.utils.ResponseStatus;
import com.zby.demo.utils.ResultMessage;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author zby
 * 权限拦截
 */
@Component
public class PermissionInterceptor extends HandlerInterceptorAdapter {
    @Resource
    private UserService userService;
    @Resource
    private RedisTemplate redisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod method = (HandlerMethod)handler;
        if (method.getMethod().getName().equals("login") || method.getMethod().getName().equals("register")) {
            return super.preHandle(request, response, handler);
        }
        if (request.getParameter("token") != null) {
            User user = (User) redisTemplate.opsForValue().get(request.getParameter("token"));
            if (user == null) {
                //重置response
                response.reset();
                //设置编码格式
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json;charset=UTF-8");

                PrintWriter pw = response.getWriter();

                pw.write(ResultMessage.denied());
                return false;
            }
        } else {
            //重置response
            response.reset();
            //设置编码格式
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");

            PrintWriter pw = response.getWriter();

            pw.write(ResultMessage.denied());
            return false;
        }
        return super.preHandle(request, response, handler);
    }

}

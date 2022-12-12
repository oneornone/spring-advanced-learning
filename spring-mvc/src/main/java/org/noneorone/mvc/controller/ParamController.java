package org.noneorone.mvc.controller;

import org.noneorone.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class ParamController {

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println("session: " + session);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username + ", password:" + password);
        return "success";
    }

    @RequestMapping("/testParam")
    public String testParam(
            @RequestParam(value = "user_name", required = false, defaultValue = "mars") String username,
            String password,
            String[] hobby,
            @RequestHeader(value = "sayHello", required = true, defaultValue = "hello") String host,
            @CookieValue("JSESSIONID") String JSESSIONID) {
        //若请求参数中出现多个同名的请求参数，可以再控制器方法的形参位置设置字符串类型或字符串数组接收此请求参数
        //若使用字符串类型的形参，最终结果为请求参数的每一个值之间使用逗号进行拼接
        System.out.println("username:"+username+",password:"+password+",hobby:"+ Arrays.toString(hobby));
        System.out.println("host:"+host);
        System.out.println("JSESSIONID:"+JSESSIONID);
        return "success";
    }

    @RequestMapping("/testBean")
    public String testBean(User user) {
        System.out.println("user: " +user);
        return "success";
    }


}

package org.noneorone.boot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @RequestMapping(value = "/main")
    public String main(HttpServletRequest request) {
        System.out.println("MainAction main invoked " + request);
        return "main";
    }

}

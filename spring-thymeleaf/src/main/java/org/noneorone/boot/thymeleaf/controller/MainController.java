package org.noneorone.boot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = "/main")
    public String main() {
        System.out.println("MainAction main invoked");
        return "main";
    }

}

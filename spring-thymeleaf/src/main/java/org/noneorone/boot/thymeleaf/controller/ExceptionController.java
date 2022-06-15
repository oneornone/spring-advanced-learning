package org.noneorone.boot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exception")
public class ExceptionController extends BaseController {

    @RequestMapping("/index")
    public static String index() {
        return "exception/exception";
    }

    @RequestMapping("/hello")
    public static String hello() throws Exception {
        throw new Exception("→Hello Exception :-D");
    }

    @RequestMapping("/test")
    public static String test() throws Exception {
        System.out.println("test exception ...");
        int a = 5;
        int b = 0;
        int c = a / b;
        return "success";
    }

}

package org.noneorone.boot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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

    /**
     * 捕获当前controller中所有方法抛出的异常，而不会抛给Servlet容器
     *
     * @param e Exception
     * @return error message
     */
    @ExceptionHandler(Exception.class)
    public String testErrorHandler(HttpServletRequest request, Exception e) {
        System.out.println("testErrorHandler(): " + e.getLocalizedMessage());
        request.setAttribute("error", e);
        return "exception/error";
    }


}

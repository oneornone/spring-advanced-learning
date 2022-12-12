package org.noneorone.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = {"/target", "target2"}, method = RequestMethod.GET)
    public String toTarget() {
        return "target";
    }

    /**
     * 测试路径中的占位符
     *
     * @return 目标页面
     */
    @RequestMapping("testRest/{id}/{username}")
    public String testRest(@PathVariable("id") String id, @PathVariable("username") String username) {
        System.out.println("id:" + id + ", username:" + username);
        return "target";
    }

    @RequestMapping("testParams")
    public String testParam(String username, String password) {
        System.out.printf("username: %s, passowrd: %s%n", username, password);
        return "target";
    }

}

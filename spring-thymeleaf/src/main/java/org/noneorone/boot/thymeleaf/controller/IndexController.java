package org.noneorone.boot.thymeleaf.controller;

import org.noneorone.boot.thymeleaf.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(Model model) {
        // 若页面中有th:field="*{account}"需要显示，则需要设置属性值，否则不用设置也可以
        User user = new User();
        model.addAttribute("user", user);
        return "login/login";
    }

    @RequestMapping("/index/ajax")
    public String indexAjax() {
        return "login/login_ajax";
    }

}

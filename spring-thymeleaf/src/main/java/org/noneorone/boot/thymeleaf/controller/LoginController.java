package org.noneorone.boot.thymeleaf.controller;

import org.noneorone.boot.thymeleaf.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @PostMapping("/login/ajax")
    public String loginAjax(@RequestParam(value = "account1") String account, @RequestParam(value = "pwd1") String pwd, HttpServletRequest request, HttpSession session) {
        User user = new User(account, pwd);
        if (user.isGuest()) {
            user.setSid(session.getId());
            request.setAttribute("user", user);
            return "forward:/main";
        }
        return null;
    }

    @RequestMapping(value = "/login/form", method = RequestMethod.POST)
    public String loginForm(@ModelAttribute(value = "user") User user, HttpServletRequest request, HttpSession session) {
        if (user.isGuest()) {
            user.setSid(session.getId());
            request.setAttribute("user", user);
            return "forward:/main";
        }
        return null;
    }

}

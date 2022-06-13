package org.noneorone.boot.thymeleaf.controller;

import org.noneorone.boot.thymeleaf.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam(value = "account1") String account, @RequestParam(value = "pwd1") String pwd, HttpServletRequest request, HttpSession session) {
        User user = new User(account, pwd);
        if (user.isGuest()) {
            user.setSid(session.getId());
            request.setAttribute("user", user);
            return "/main";
        }
        return null;
    }

}

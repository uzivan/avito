package com.try_security.controllers;

import com.try_security.entity.User;
import com.try_security.service.AddUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AutController {
    @Autowired
    private AddUserService addUserService;
    @GetMapping("/hello")
    public String hello_page() {
        return "hello";
    }

    @GetMapping("/registration")
    public String registration() {
//        User user = new User();
//        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/save_user")
    public String save(HttpServletRequest request) {
        User user = new User();
        user.setEnabled(Integer.parseInt(request.getParameterValues("enabled")[0]));
        user.setPassword(request.getParameterValues("password")[0]);
        user.setUsername(request.getParameterValues("username")[0]);
        String[] roles = request.getParameterValues("role");
        addUserService.addUser(user, roles);
        return "redirect: ";
    }
}

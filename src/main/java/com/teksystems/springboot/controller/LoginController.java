package com.teksystems.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("/user/createuser")
    public ModelAndView createUser() {
        ModelAndView response = new ModelAndView();
        response.setViewName("login_pages/create_user");
        return response;
    }
}
